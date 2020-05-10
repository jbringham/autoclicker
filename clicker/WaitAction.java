/**
 * 
 */
package clicker;

import java.awt.Robot;

/**
 * @author Jacob Bringham
 *
 */
public class WaitAction implements Action {

  private int time;

  /**
   * Explicit value constructor.
   * 
   * @param time time to wait in milliseconds
   */
  public WaitAction(int time) {
    super();
    this.time = time;
  }

  @Override
  public void execute(Robot robot) {
    robot.delay(time);
  }

  /**
   * @return the time
   */
  public int getTime() {
    return time;
  }

  /**
   * @param time the time to set
   */
  public void setTime(int time) {
    this.time = time;
  }

}
