
public class BankAccount implements Bank {

  private int balance;

  public BankAccount() {
    this(0);
  }

  public BankAccount(int initialBalance) {
    this.balance = initialBalance;
  }

  /**
   * Returns the Bank account balance to see how much money is currently saved up.
   *
   * @return The total amount of money that the player has saved up
   */
  public int getBalance() {
    return balance;
  }

  /**
   * Increase the Bank account balance by adding money to the current balance.
   *
   * @param amount The amount of money to add to the Bank account balance
   */
  public void increaseBalance(int amount) {
    if(amount >= 0) {
      balance += amount;
    }
  }

  /**
   * Decrease the Bank account balance by subtracting money from the current balance.
   *
   * @param amount The amount of money to remove from the Bank account balance
   */
  public void decreaseBalance(int amount) {
    if(amount >= 0) {
      balance -= amount;
    }
  }

}