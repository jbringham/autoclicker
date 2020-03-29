package clicker;

import java.awt.AWTException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import clicker.AbstractInstruction.Type;
import clicker.CompositeInstruction.Execution;

public class LeafInstruction extends AbstractInstruction implements Instruction
{
  
  public static void main(String args[])
  {
    LeafInstruction move = new LeafInstruction(Type.MOUSE_MOVE, new Point(500, 500), 0);
    LeafInstruction click = new LeafInstruction(Type.MOUSE_PRESS_1, new Point(500, 500), 0);
    LeafInstruction wait = new LeafInstruction(Type.WAIT, new Point(500, 500), 5000);
    // LeafInstruction click1 = new LeafInstruction(Type.MOUSE_RELEASE, new Point(500, 500), 0);
    // LeafInstruction click2 = new LeafInstruction(Type.MOUSE_PRESS_1, new Point(500, 500), 0);
    // LeafInstruction click3 = new LeafInstruction(Type.MOUSE_RELEASE, new Point(500, 500), 0);
    LeafInstruction type = new LeafInstruction(Type.TYPE, new Point(500, 500), 0, "penis"
        + "\n");
    LeafInstruction enter = new LeafInstruction(Type.TYPE, new Point(500, 500), 0, "\n");
    // CompositeInstruction comp = new CompositeInstruction(Execution.SEQUENTIAL, move, click,
    // click1, click2, click3, type);
    CompositeInstruction comp = new CompositeInstruction(Execution.SEQUENTIAL, type);
    //
    try
    {
      while (true)
      {
        comp.execute(new Robot());
      }

    }
    catch (AWTException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Constructs a LeafInstruction with the initialized fields.
   * 
   * @param action
   *          Action
   * @param location
   * @param time
   */
  public LeafInstruction(Type action, Point location, int time)
  {
    super(action, location, time);
  }

  public LeafInstruction(Type type, Point point, int i, String string)
  {
    super(type, point, i, string);
  }

  @Override
  public void execute(Robot robot)
  {
    switch (action)
    {
      case MOUSE_PRESS_1:
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        break;

      case MOUSE_PRESS_2:
        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        break;

      case MOUSE_RELEASE:
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
        break;

      case MOUSE_MOVE:
        robot.mouseMove(location.x, location.y);
        break;
      case KEY_PRESS:
        robot.keyPress(text.charAt(0));
        break;

      case KEY_RELEASE:
        robot.keyRelease(text.charAt(0));
        break;

      case TYPE:
        for (char letter : text.toCharArray())
        {
          try
          {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(letter));
            //System.out.printf("Pressing %c%n", letter);
            robot.delay(1);
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(letter));
          }
          catch(Exception e)
          {
            System.err.printf("Invalid character \"%c\" was typed.%n", letter);
          }
        }
        break;
      case MOUSE_SCROLL_UP:
        robot.mouseWheel(1);
        break;

      case MOUSE_SCROLL_DOWN:
        robot.mouseWheel(1);
        break;

      case WAIT:
        robot.delay(time);
        break;

      default:
        System.err.printf("Instruction could not be interpreted. %s%n", action.toString());
        break;
    }

  }

  @Override
  public String toString()
  {
    return String.format("%s, %s, %d sec, \"%s\"", action.toString(), location.toString(), time,
        text);
  }

}
