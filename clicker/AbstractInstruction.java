package clicker;

import java.awt.Point;

/**
 * Represents the commonalities between a LeafInstruction and a CompositeInstruction.
 * 
 * @author Jacob Bringham
 * @version 3/26/2020
 */
public class AbstractInstruction
{



  public static enum Type
  {
    MOUSE_PRESS_1, MOUSE_PRESS_2, MOUSE_RELEASE, MOUSE_MOVE, MOUSE_SCROLL_UP, MOUSE_SCROLL_DOWN, KEY_PRESS, KEY_RELEASE, WAIT, TYPE
  };

  public final static int DEFAULT_TIME = -1;

  protected Type action;
  protected Point location;
  protected int time;
  protected String text;

  /**
   * Creates an Instruction with the initialized fields.
   * 
   * @param action
   * @param location
   * @param time
   * @param text
   */
  public AbstractInstruction(Type action, Point location, int time, String text)
  {
    this.action = action;
    this.location = location;
    this.time = time;
    this.text = text;
  }
  
  /**
   * Creates an Instruction with the initialized fields. Text is initialized to an empty string.
   * 
   * @param action
   * @param location
   * @param time
   */
  public AbstractInstruction(Type action, Point location, int time)
  {
    this(action, location, time, "");
  }

  /**
   * Constructs a Instruction with a default value of -1.
   * 
   * @param action
   *          Action type, should not be wait
   * @param location
   */
  public AbstractInstruction(Type action, Point location)
  {
    this(action, location, DEFAULT_TIME);
  }
  
  /**
   * Constructs an Instruction with the given action type.
   * @param action
   */
  public AbstractInstruction(Type action) {
    this(action, new Point(0, 0), DEFAULT_TIME);
  }

  /**
   * @return the action
   */
  public Type getAction()
  {
    return action;
  }

  /**
   * @param action
   *          the action to set
   */
  public void setAction(Type action)
  {
    this.action = action;
  }

  /**
   * @return the location
   */
  public Point getLocation()
  {
    return location;
  }

  /**
   * @param location
   *          the location to set
   */
  public void setLocation(Point location)
  {
    this.location = location;
  }

  /**
   * @return the time
   */
  public int getTime()
  {
    return time;
  }

  /**
   * @param time
   *          the time to set
   */
  public void setTime(int time)
  {
    this.time = time;
  }

}
