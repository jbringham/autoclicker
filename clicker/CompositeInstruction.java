package clicker;

import java.awt.Point;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Represents an instruction that is a collection of instructions that could be executed
 * sequentially or concurrently.
 * 
 * @author Jacob Bringham
 * @version 3/26/2020
 */
public class CompositeInstruction implements Instruction
{

  /**
   * Allows specification of how to execute the CompositeInstruction.
   */
  public static enum Execution
  {
    SEQUENTIAL, CONCURRENT
  };

  private Collection<Instruction> instructions;
  private Execution action;
  
  public CompositeInstruction(Execution action, Instruction... instructions)
  {
    // TODO: Consider using different data structure
    this.instructions = new ArrayList<Instruction>();
    // TODO: Write test to ensure order is preserved
    this.instructions.addAll(Arrays.asList(instructions));
    this.action = action;
  }

  /**
   * Adds an Instruction to this composite instruction.
   * @param i Instruction to add
   */
  public void add(Instruction i)
  {
    instructions.add(i);
  }

  /**
   * Removes an Instruction to this composite instruction.
   * @param i Instruction to remove
   */
  public void remove(Instruction i)
  {
    instructions.remove(i);
  }
  
  @Override
  public void execute(Robot robot)
  {
    // TODO: Figure out how to do conncurrent actions
    for (Instruction instruction : instructions)
    {
      instruction.execute(robot);
    }
  }

}
