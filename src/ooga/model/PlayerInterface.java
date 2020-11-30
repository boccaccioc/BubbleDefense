package ooga.model;

import ooga.model.tower.Tower;

public interface PlayerInterface {
  /**
   * Returns the number of lives that a player has remaining.
   *
   * @return Number of lives this player has left
   */
  int getLivesLeft();

  /**
   * Decreases the player's lives left by one
   */
  void loseOneLife();

  /**
   * Increases the player's lives left by one
   */
  void gainOneLife();

  /**
   * Returns a player's Bank account balance to see how much money they currently have saved up.
   *
   * @return The total amount of money that the player has saved up
   */
  int getBalance();

  /**
   * Increase the player's Bank account balance by adding money to the player's account
   *
   * @param amount The amount of money to add to the player's Bank account
   */
  void increaseBalance(int amount);

  /**
   * Returns a boolean indicating whether or not the player has enough money to buy this specific
   * tower.
   *
   * @param tower The tower that the player wants to buy
   * @return Boolean indicating if the player has enough money to buy the tower
   */
  boolean canAffordTower(Tower tower);

  /**
   * Subtracts the cost of the Tower from the player's total Bank account balance, and adds the
   * tower to the list of towers that a player has.
   *
   * @param tower The tower that the player buys
   */
  void purchaseTower(Tower tower);
}
