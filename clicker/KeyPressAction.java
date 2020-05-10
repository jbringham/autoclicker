package clicker;

import java.awt.Robot;

/**
 * This class represents a key press that will be performed by the autoclicker.
 * @author Jacob Bringham
 *
 */
public class KeyPressAction implements Action {

  private char letter;

  /**
   * Explicit value constructor.
   * 
   * @param letter to be typed
   */
  public KeyPressAction(char letter) {
    this.letter = letter;
  }


  @Override
  public void execute(Robot robot) {
    robot.keyPress(letter);
  }

  /**
   * @return the letter
   */
  public char getLetter() {
    return letter;
  }

  /**
   * @param letter the letter to set
   */
  public void setLetter(char letter) {
    this.letter = letter;
  }

}
