package reference;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Jacob Bringham
 *
 */
public class Autoclicker
{
  private final static Scanner input = new Scanner(System.in);

  private static void click(Robot r, int x, int y)
  {
    r.mouseMove(x, y);
    r.delay(500);
    r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    r.delay(250);
    r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
  }

  private static Instruction[] getInstructions(File file)
  {
    Scanner fileReader = null;
    try
    {
      fileReader = new Scanner(file);
      ArrayList<Instruction> instr = new ArrayList<>();
      while (fileReader.hasNextLine())
      {
        String[] parts = fileReader.nextLine().split(" ");
        String[] args = parts[1].split(",");
        Instruction i = new Instruction(parts[0], args);
        // System.out.println(i);
        instr.add(i);
      }
      // return (Instruction[])instr.toArray();
      Instruction[] arr = new Instruction[instr.size()];
      for (int i = 0; i < instr.size(); i++)
      {
        arr[i] = instr.get(i);
      }
      System.out.println("Successfully loaded instructions.");
      return arr; // C:\Users\jakeb\Documents\grubguardian.txt
    }
    catch (FileNotFoundException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    finally
    {
      if (fileReader != null)
      {
        fileReader.close();
      }
    }
    return new Instruction[] {};
  }

  private static void runInstruction(Robot r, Instruction i) throws InterruptedException
  {
    System.out.println(i);
    switch (i.getType())
    {
      case "CLICK":
        click(r, i.getXPoint(), i.getYPoint());
        break;
      case "WAIT":
        // r.delay(i.getTime());
        Thread.sleep((long) i.getTime());
        break;
      default:
        System.out.println("Unknown instruction \'" + i + "\'");
    }
  }

  private static void runMacro(File file) throws AWTException, InterruptedException
  {
    Instruction[] instructions = getInstructions(file);
    Robot r = new Robot();
    for (Instruction i : instructions)
    {
      runInstruction(r, i);
    }
    System.out.println("Finished executing macro.");
  }

  private static boolean isFileValid(String fileName)
  {
    boolean valid = false;
    File f = new File(fileName);
    if (f != null)
    {
      try
      {
        // attempt to open
        Scanner s = new Scanner(f);
        s.close();
        valid = true;
      }
      catch (FileNotFoundException ex)
      {
        System.err.println(ex.getMessage());
        valid = false;
      }
    }
    return valid;
  }

  /**
   * Runs the program.
   * 
   * @param args
   *          Unused
   * @throws AWTException
   * @throws InterruptedException
   */
  public static void main(String[] args) throws AWTException, InterruptedException
  {
    System.out.println("Welcome to Jake Bringham's AutoClicker!");
    System.out.println("1    \t- Print Mouse Location");
    System.out.println("2    \t- Run Macro");
    System.out.println("Any #\t- Quit");

    while (true)
    {
      System.out.print("Enter Action: ");

      try
      {
        int action = Integer.parseInt(input.next());
        switch (action)
        {
          case 1:
            // Make macro
            System.out.println(MouseInfo.getPointerInfo().getLocation());
            break;
          case 2:
            // Run macro

            boolean validFile = false;
            String fileName = "";

            if (!(args.length >= 1))
            {
              while (!validFile)
              {
                System.out.print("Enter name of instruction file: ");
                fileName = input.next();
                validFile = isFileValid(fileName);
              }
            }
            else
            {
              validFile = true;
              fileName = args[0];
            }

            System.out.print("Amount of energy: ");
            boolean validNum = false;
            int numEnergy = 0;
            while (!validNum)
            {
              try
              {
                numEnergy = Integer.parseInt(input.next());
                validNum = true;
              }
              catch (NumberFormatException e)
              {
                validNum = false;
              }
            }

            System.out.print("Amount of energy per run: ");
            boolean validNum2 = false;
            int numEnergyPerRun = 0;
            while (!validNum2)
            {
              try
              {
                numEnergyPerRun = Integer.parseInt(input.next());
                validNum2 = true;
              }
              catch (NumberFormatException e)
              {
                validNum2 = false;
              }
            }

            // runMacro(new File(fileName));

            loopMacro(fileName, numEnergy / numEnergyPerRun);

            break;
          default:
            System.out.println("Exiting program...");
            input.close();
            System.exit(0);
        }
      }
      catch (NumberFormatException e)
      {
        System.out.println("Error processing input, please enter a valid number.");
      }

    }
  }

  /**
   * Runs the macro as many times as specified
   * 
   * @param filename
   *          Filename of the instruction macro
   * @param times
   *          Amount of times to run the macro
   * @throws InterruptedException
   * @throws AWTException
   */
  public static void loopMacro(String fileName, int times) throws AWTException, InterruptedException
  {
    if (isFileValid(fileName))
    {
      for (int i = 0; i < times; i++)
      {
        runMacro(new File(fileName));
        Thread.sleep(3000);
      }
    }
    System.out.println("Finished Looping Macro, exiting...");
    System.exit(0);
  }
}
