
public interface Level {

  /**
   * Set how many total bubbles the level will have
   *
   * @param numBubbles
   */
  void setNumberBubbles(int numBubbles);

  /**
   * Set how many lives a player has for that specific level
   *
   * @param numLives The number of lives a player should start this level with
   */
  void setNumberOfLives(int numLives);

}