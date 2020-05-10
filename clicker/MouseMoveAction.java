package clicker;

import java.awt.Point;
import java.awt.Robot;

/**
 * This class represents a Mouse Move action where it moves your cursor to a location on the screen.
 * 
 * @author Jacob Bringham
 *
 */
public class MouseMoveAction implements Action {

  private Point location;

  /**
   * Explicit value constructor.
   * 
   * @param location Location of where to move the cursor to
   */
  public MouseMoveAction(Point location) {
    this.location = location;
  }

  @Override
  public void execute(Robot robot) {
    robot.mouseMove(location.x, location.y);
  }

  /**
   * @return the location
   */
  public Point getLocation() {
    return location;
  }

  /**
   * @param location the location to set
   */
  public void setLocation(Point location) {
    this.location = location;
  }

}
