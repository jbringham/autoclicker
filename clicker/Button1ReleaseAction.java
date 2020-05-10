/**
 * 
 */
package clicker;

import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * @author Jacob Bringham
 *
 */
public class Button1ReleaseAction implements Action {

  @Override
  public void execute(Robot robot) {
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
  }

}
