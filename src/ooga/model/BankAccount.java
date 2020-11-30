package ooga.model;

public class BankAccount implements Bank {

  private double balance;
  private double myEndOfRoundIncome;

  //TODO add a way to determine when rounds end and add end of round income

  public BankAccount(double initialBalance, double endOfRoundIncome) {
    balance = initialBalance;
    myEndOfRoundIncome = endOfRoundIncome;
  }

  /**
   * Returns the Bank account balance to see how much money is currently saved up.
   *
   * @return The total amount of money that the player has saved up
   */
  public int getBalance() {
    return (int)balance;
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

  /**
   * adds end of round income to balance
   */
  public void addEndOfRoundIncomeToBalance(){
    balance+=myEndOfRoundIncome;
  }
}
