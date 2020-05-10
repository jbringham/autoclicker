/**
 * 
 */
package clicker;

import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * This class represents an action from a mouse press from Button1 on a mouse.
 * 
 * @author Jacob Bringham
 *
 */
public class Button1PressAction implements Action {

  @Override
  public void execute(Robot robot) {
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
  }

}
