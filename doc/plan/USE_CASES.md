### USER CASES


Player Buys A Tower

String desiredTower = towerClicked(Button)
Tower newTower = createTower(desiredTower)
placeTower(int mouseX, int mouseY)
Bank.updateBalance(-1 * newTower.getCost())

Bank Balance Increases

List<Bubble> onScreenBubbles
for(Bubble b : onScreenBubbles)
    if(b.bubblePopped()){
        Bank.updateBalance(b.getPrize());
    }
}

 
### Luisa
 
Feature 1: When the user passes a level - a new .sim property file will be read with all the information for that level: grid size, csv file with track format, type of towers in the game, number of lives, initial money.
 
Feature 2: Add .css file to the layout of the game so that each level contains different color code
 
Feature 3: Add image reading method to add towers as image to the grid (ex: image of a shark, puffer fish)
 
Feature 4: Make initial screen layout where the player hits play and it launches the game.
 
Feature 5: Make slow down and speed up buttons for game pace.

### Colin
 
Feature 1: Create a Controller and Main
 
Feature 2: Implement a system to read in and utilize data from properties file
 
Feature 3: Work on Tower Abstraction 
 
Feature 4: Create an upgrade System for Towers
 
Feature 5: Work on Banking System
 
### Liam
 
Feature 1: Create an abstract Tower class and one initial subclass SeaHorse.
 
Feature 2: Configure a level by reading from a CSV file.
 
Feature 3: Add sound fx to the game that play everytime a enemy is popped or a projectile is shot. Also add music
 
Feature 4: Create Sprites on the front end that correspond to the different types of enemies and towers that we can create.
 
Feature 5: Implement the purchaseTower(Tower t) method in Player class which adds a tower to a list of the players defenses and
           subtracts the cost of the tower from the player's bank account.
 
### Emily
 
Feature 1: Create Level abstract class that is easy to extend for future complex levels.
 
Feature 2: Create specific Level implementations for beginning simple levels.
 
Feature 3: Integrate level creation into Controller
 
Feature 4: Work on defender hierarchy
 
Feature 5: Turn the data read from CSV's into useful information for each Level (locations to place towers, travel path, etc.)
 
### Kenneth
 
Feature 1: 
 
Feature 2: 
 
Feature 3: 
 
Feature 4: 
 
Feature 5: 

 
