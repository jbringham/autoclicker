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
public class Button2PressAction implements Action {

  @Override
  public void execute(Robot robot) {
    robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
  }

}
