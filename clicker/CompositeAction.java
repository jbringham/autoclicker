package clicker;

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
public class CompositeAction implements Action {

  private Collection<Action> instructions;

  public CompositeAction(Action... instructions) {
    // TODO: Consider using different data structure
    this.instructions = new ArrayList<Action>();
    // TODO: Write test to ensure order is preserved
    this.instructions.addAll(Arrays.asList(instructions));
  }

  /**
   * Adds an Instruction to this composite instruction.
   * 
   * @param i Instruction to add
   */
  public void add(Action i) {
    instructions.add(i);
  }

  /**
   * Removes an Instruction to this composite instruction.
   * 
   * @param i Instruction to remove
   */
  public void remove(Action i) {
    instructions.remove(i);
  }

  @Override
  public void execute(Robot robot) {
    // TODO: Figure out how to do concurrent actions
    for (Action instruction : instructions) {
      instruction.execute(robot);
    }
  }

}
