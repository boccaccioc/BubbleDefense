
public class LevelClass implements Level {

  private int level;
  private int numBubbles;
  private Player player;

  public LevelClass(int level, int numBubbles, Player player) {
    this.level = level;
    this.numBubbles = numBubbles;
    this.player = player;
  }

  /**
   * Set how many total bubbles the level will have
   *
   * @param numBubbles The number of total bubbles the level will have
   */
  public void setNumberBubbles(int numBubbles) {
    if (numBubbles > 0) {
      this.numBubbles = numBubbles;
    }
  }

  /**
   * Set how many lives a player has for that specific level
   *
   * @param numLives The number of lives a player should start this level with
   */
  public void setNumberOfLives(int numLives) {
    player.setNumLives(numLives);
  }
}