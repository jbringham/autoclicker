package clicker;

import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class LeafInstruction extends AbstractInstruction implements Instruction {

  /**
   * Constructs a LeafInstruction with the initialized fields.
   * 
   * @param action Type of action to be performed
   * @param location Location the action will act on
   * @param time The length of the time action will act over
   */
  public LeafInstruction(Type action, Point location, int time) {
    super(action, location, time);
  }

  public LeafInstruction(Type type, Point point, int i, String string) {
    super(type, point, i, string);
  }
  
  @Override
  public void execute(Robot robot) {
    switch (action) {
      case MOUSE_PRESS_1:
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        break;

      case MOUSE_PRESS_2:
        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        break;

      case MOUSE_RELEASE:
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);
        break;

      case MOUSE_MOVE:
        robot.mouseMove(location.x, location.y);
        break;
      case KEY_PRESS:
        robot.keyPress(text.charAt(0));
        break;

      case KEY_RELEASE:
        robot.keyRelease(text.charAt(0));
        break;

      case TYPE:
        for (char letter : text.toCharArray()) {
          try {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(letter));
            // System.out.printf("Pressing %c%n", letter);
            robot.delay(1);
            robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(letter));
          } catch (Exception e) {
            System.err.printf("Invalid character \"%c\" was typed.%n", letter);
          }
        }
        break;
      case MOUSE_SCROLL_UP:
        robot.mouseWheel(1);
        break;

      case MOUSE_SCROLL_DOWN:
        robot.mouseWheel(1);
        break;

      case WAIT:
        robot.delay(time);
        break;

      default:
        System.err.printf("Instruction could not be interpreted. %s%n", action.toString());
        break;
    }

  }

  @Override
  public String toString() {
    return String.format("%s, %s, %d sec, \"%s\"", action.toString(), location.toString(), time,
        text);
  }

}
