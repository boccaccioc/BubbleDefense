package ooga.model;

import java.util.ArrayList;
import java.util.List;
import ooga.controller.Properties.BankProperties;
import ooga.controller.PropertiesReader;
import ooga.model.tower.Tower;

public class Player implements PlayerInterface {

  private int livesLeft;
  private List<Tower> towersOwned;
  private BankAccount bank;

  /**
   * @param propReader properties used to create the player
   * @param livesLeft number of lives this player starts with
   */
  public Player(PropertiesReader propReader, int livesLeft) {
    this.livesLeft = livesLeft;
    towersOwned = new ArrayList<>();
    BankProperties bankProps = propReader.getBankProperties();
    bank = new BankAccount(bankProps.getInitialBalance(), bankProps.getEndOfRoundIncome());
  }

  public int getLivesLeft() {
    return livesLeft;
  }

  public void loseOneLife() {
    if (livesLeft > 0) {
      livesLeft--;
    }
  }

  public void gainOneLife() {
    livesLeft++;
  }

  /**
   * Returns a player's Bank account balance to see how much money they currently have saved up.
   *
   * @return The total amount of money that the player has saved up
   */
  public int getBalance() {
    return bank.getBalance();
  }

  /**
   * Increase the player's Bank account balance by adding money to the player's account
   *
   * @param amount The amount of money to add to the player's Bank account
   */
  public void increaseBalance(int amount) {
    bank.increaseBalance(amount);
  }

  public void decreaseBalance(int amount) {
    bank.decreaseBalance(amount);
  }

  /**
   * Returns a boolean indicating whether or not the player has enough money to buy this specific
   * tower.
   *
   * @param tower The tower that the player wants to buy
   * @return Boolean indicating if the player has enough money to buy the tower
   */
  public boolean canAffordTower(Tower tower) {
    return tower.getPrice() <= this.bank.getBalance();
  }

  /**
   * Subtracts the cost of the Tower from the player's total Bank account balance, and adds the
   * tower to the list of towers that a player has.
   *
   * @param tower The tower that the player buys
   */
  public void purchaseTower(Tower tower) {
    if (this.canAffordTower(tower)) {
      bank.decreaseBalance(tower.getPrice());
      towersOwned.add(tower);
    }
  }

  public void addEndOfRoundIncome(){
    bank.addEndOfRoundIncomeToBalance();
  }

}
