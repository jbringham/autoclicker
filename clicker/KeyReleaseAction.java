package clicker;

import java.awt.Robot;

/**
 * This class represents a key to be released by the Autoclicker.
 * 
 * @author Jacob Bringham
 *
 */
public class KeyReleaseAction implements Action {

  private char letter;

  /**
   * Explicit value constructor.
   * 
   * @param letter to be released
   */
  public KeyReleaseAction(char letter) {
    this.letter = letter;
  }

  @Override
  public void execute(Robot robot) {
    robot.keyRelease(letter);
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
