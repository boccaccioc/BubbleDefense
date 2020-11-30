
public class PlayerClass implements Player {

  private int livesLeft;
  private int score;
  private List<Tower> towers;
  private BankAccount bank;

  public PlayerClass() {
    this.score = 0;
    this.towers = new ArrayList<>();
    this.bank = new BankAccount();
  }

  /**
   * Returns the number of lives that a player has remaining.
   *
   * @return Number of lives this player has left
   */
  public int getLivesLeft() {
    return livesLeft;
  }

  /**
   * Decreases the player's lives left by one
   */
  public void loseOneLife() {
    livesLeft--;
  }

  /**
   * Increases the player's lives left by one
   */
  public void gainOneLife() {
    livesLeft++;
  }

  /**
   * Returns the player's current score
   *
   * @return The number of points the player currently has
   */
  public int getScore() {
    return score;
  }

  /**
   * Increments a player's score by the specified number of points. Does error checking to ensure
   * that the score is a valid score, meaning that it is a positive integer less than 2^31 - 1.
   *
   * @param points The number of points to add to a player's score
   */
  public void increaseScore(int points) {
    if(points >= 0) {
      score += points;
    }
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

  /**
   * Returns a boolean indicating whether or not the player has enough money to buy this specific
   * tower.
   *
   * @param tower The tower that the player wants to buy
   * @return Boolean indicating if the player has enough money to buy the tower
   */
  public boolean canAffordTower(Tower tower) {
    return tower.getPrice() <= bank.getBalance();
  }

  /**
   * Subtracts the cost of the Tower from the player's total Bank account balance, and adds the
   * tower to the list of towers that a player has.
   *
   * @param tower The tower that the player buys
   */
  public void purchaseTower(Tower tower) {
    if(this.canAffordTower(tower)) {
      bank.decreaseBalance(tower.getPrice());
      towers.add(tower);
    }
  }

}