
public interface Tower {

  /**
   * Returns the range that the tower can shoot bubbles to determine if a bubble is close enough in
   * proximity to the tower in order to shoot it.
   *
   * @return The range that the tower can shoot bubbles
   */
  Range getPoppingRange();

  /**
   * Returns a Damage object, so that you can "apply" damage to a balloon. The Damage will typically
   * be how many bubbles it can pop at once, the type of bubbles it can pop at once, or a certain
   * way of destroying balloons.
   *
   * @return The type of damage this tower inflicts
   */
  Damage getDamageType();

  /**
   * Returns the rate at which the tower shoots out defender objects, represented as the number of
   * defenders shot out per second.
   *
   * @return The rate that the tower shoots out defender objects (number of defenders/1 second)
   */
  double getShootingRate();

  /**
   * Return a List of angles (in degrees) representing the angles in which defenders should be
   * launched. The length of this list is the number of defenders to be launched in one step.
   *
   * @return A list of angles in which to launch defenders
   */
  List<Double> getShootingDirections();

  /**
   * Fires the tower in order to launch all of the defenders in one step.
   */
  void fire();

}