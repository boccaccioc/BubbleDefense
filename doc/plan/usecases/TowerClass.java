
public class TowerClass implements Tower {

  private Range poppingRange;
  private Damage damageType;
  private double shootingRate;
  private List<Double> shootingDirections;

  public TowerClass() {

  }

  /**
   * Returns the range that the tower can shoot bubbles to determine if a bubble is close enough in
   * proximity to the tower in order to shoot it.
   *
   * @return The range that the tower can shoot bubbles
   */
  public Range getPoppingRange() {
    return poppingRange;
  }

  /**
   * Returns a Damage object, so that you can "apply" damage to a balloon. The Damage will typically
   * be how many bubbles it can pop at once, the type of bubbles it can pop at once, or a certain
   * way of destroying balloons.
   *
   * @return The type of damage this tower inflicts
   */
  public Damage getDamageType() {
    return damageType;
  }

  /**
   * Returns the rate at which the tower shoots out defender objects, represented as the number of
   * defenders shot out per second.
   *
   * @return The rate that the tower shoots out defender objects (number of defenders/1 second)
   */
  public double getShootingRate() {
    return shootingRate;
  }

  private void findShootingDirections(List<Bubble> bubbles) {
    // based on each bubble's location, find the angle(s) to shoot defenders
  }

  /**
   * Return a List of angles (in degrees) representing the angles in which defenders should be
   * launched. The length of this list is the number of defenders to be launched in one step.
   *
   * @return A list of angles in which to launch defenders
   */
  public List<Double> getShootingDirections() {
    return shootingDirections;
  }

  /**
   * Fires the tower in order to launch all of the defenders in one step.
   */
  public void fire() {
    // create all necessary defenders, and launch them based on shootingDirections
  }
}