package ooga.model.tower;

/**
 * TowerType enum for tower ids.
 *
 * @author Liam Clark
 */
public enum TowerType  {

    GOLDFISH("Goldfish", 1),
    PUFFER("Pufferfish", 2),
    OCTOPUS("Octopus", 3),
    SEAHORSE("Seahorse", 4),
    SUBMARINE("Submarine", 5);


    private final String towerType;
    private final int towerNumber;

    TowerType(String tType, int towerValue) {
        this.towerType = tType;
        this.towerNumber = towerValue;
    }

    /**
     * Method used to retrieve the tower's type as a string
     *
     * @return type of the tower
     */
    public String getTowerType() {
        return towerType;
    }

    /**
     * Method called to return integer value associated with tower
     *
     * @return towerNumber - the number associated to the tower.
     */
    public int getTowerNumber() {
        return towerNumber;
    }

}