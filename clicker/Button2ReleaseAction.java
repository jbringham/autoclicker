package clicker;

import java.awt.Robot;
import java.awt.event.InputEvent;

/**
 * 
 * @author Jacob Bringham
 *
 */
public class Button2ReleaseAction implements Action {

  @Override
  public void execute(Robot robot) {
    robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
  }

}
