/**
 * 
 */
package clicker;

/**
 * @author Jacob Bringham
 *
 */
public class TypeLetterAction extends CompositeAction implements Action {

  private char letter;
  public final int TIME_HELD = 10;

  /**
   * Explicit value constructor.
   * 
   * @param letter to be typed
   */
  public TypeLetterAction(char letter) {
    setLetter(letter);
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
    this.removeAll();
    this.add(new KeyPressAction(letter));
    this.add(new WaitAction(TIME_HELD));
    this.add(new KeyReleaseAction(letter));
  }

}
