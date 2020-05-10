/**
 * 
 */
package clicker;

/**
 * @author Jacob Bringham
 *
 */
public class TypeTextAction extends CompositeAction implements Action {

  private String text;
  
  public TypeTextAction(String text) {
    setText(text);
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
    for(char letter : text.toCharArray()) {
      this.add(new TypeLetterAction(letter));
    }
  }

  
}
