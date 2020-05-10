package clicker;

import java.awt.Robot;

public class MouseScrollAction implements Action {

  private int amount;

  public MouseScrollAction(int amount) {
    this.amount = amount;
  }

  @Override
  public void execute(Robot robot) {
    robot.mouseWheel(amount);
  }

  /**
   * @return the amount
   */
  public int getAmount() {
    return amount;
  }

  /**
   * @param amount the amount to set
   */
  public void setAmount(int amount) {
    this.amount = amount;
  }

}
