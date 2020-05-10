package clicker;

import java.awt.Robot;

/**
 * Represents an interface which uses the composite pattern for instructions. This allows
 * instructions to be built up from basic actions such as clicks and key presses and releases. The
 * composite instruction allows for concurrent keystrokes and common movements such as a mouse move
 * and click.
 * 
 * @author Jacob Bringham
 * @version 3/26/2020
 */
public interface Action
{

  /**
   * Uses the passed robot to execute the instruction.
   * 
   * @param robot
   *          Robot to be used to execute instruction
   */
  public void execute(Robot robot);

}
