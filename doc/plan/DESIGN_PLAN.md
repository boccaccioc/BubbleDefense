### Introduction
 
We decided to make a tower defense game with an underwater theme and towers that are different underwater creatures, where we can add sea creatures that shoot out seashells at nearby enemies. The primary design goals are to be open for new level implementations (we plan on having a level factory class that allows for a more flexible implementation of additional levels), open to new tower configurations (have a tower superclass that is extended to the subclasses that are specific to each tower, because all of them need to implement shooting methods), new types of enemies (have a enemy abstract class that extends to specific types of enemies), different levels of difficulty. We are going to base our design in the MVC model where we will have a model class or package with many classes that takes care of the general back-end portion of our code. A view or player class/package that contains all methods that take care of the visual implementation of our code (layout of each level, the visual appearances of each tower, the background music of our game). And a controller class that links both the model and player part of our code by making sure the view is updated every time the model calls for a change.
 
 
### Overview
 
* Main: (Creates and runs controller)
* Controller: (Creates JavaFX scene and manages player inputs)
* Player: (Stores data such as remaining lives and money balance)
* Bank: (Adds money to the player at the end of every round and when enemies are popped, subtracts method when the player purchases a tower or an upgrade)
* Tower (Abstract Class with getters and setters for attributes such as damage and range)(Would contain upgrade methods that can add to base stats or add new abilities)
    * Example Subclass: Pufferfish has range and damage attributes in addition to unique stats such as number of directions it can shoot in
* Bubble (Abstract Class with getters and setters for attributes such as hitsUntilPop and speed)
    * Example Subclass: ExplosiveBubble that can only be damaged by an explosive seashell.
* SeaShell (Abstract Class with getters and setters for type, velocity, damageNumber, firingRate)
    * Example Subclass: ExplosiveSeaShell that does more damage than a normal SeaShell, is slower and has a slower firing rate
* Grid(Abstract class with getters and setters for grid data, numberRows, numberCols)
* Neighborhood (Enumerated type with all possible configurations of a neighborhood that a tower can have)
 
### Design Details
 
Main modules:
 
* Controller : contains setup scene method as well as the step method that makes sure the scene is updated every time a change happens in model (a enemy is popped, the enemies move, etc)
 
* Player API - getLivesLeft()- returns the lives remaining that a player has,
addScore() - increments a player’s score, getMoneyBalance() - returns the total amount of money the player has saved up, purchaseTower(Tower t) - subtracts the cost of the Tower t from the player’s money balance
 
* Level API - sets up each level rules and difficulty. It is a superclass that can extend other levels. setNumberBubbles() - set how many enemies the level will have. setNumberOfLives() - set how many lives a player has for that specific level.
 
* Bank API : getBalance() - returns current money available after each time player pops a enemy, updateBalance()- updates the current amount of money in the bank
 
* Tower API : abstract superclass that extends its methods to different towers. poppingRange() - how further away from its range does the tower shoots seashells at, damageType()- how many enemy it can pop at once, or what type of enemies it can pop at once, attackSpeed()- how frequent it shoots seashells , shootingDirection()- which way does it shoot seashells (follows enemy location, shoots in every direction, shoots in a set direction)
 
We decided to create the classes as specified above with as much flexibility as possible so that it will be easy to modify the game by adding new subclasses to the code. In specific adding a new level can be done by adding a new subclass to the Level superclass. Adding a new tower can be done by extending tower superclass to other towers.
 
 
 
### Example games
 
Because we decided on making a more complex tower defense game, we decided to focus on a single game with many level variations. On the next lines we describe our three first levels:
 
* level 1 - allows the user to buy only one type of tower (the simplest one), contains only one type of enemy (the easiest to pop), has the easiest type of track (enemy path).
 
* level 2 - allows the user to buy 2 types of towers (the 2 simplest ones), contains only 2 types of enemies, has an easy type of track (enemy path).
 
* level 3 - allows the user to buy only more types of towers (maybe 3), contains 2 types of enemies that are faster, has a medium level of difficulty track (enemy path).
 
Note: easier the track, the longer it is, as it gives more time for the player to pop the balloon.
 
### Design Considerations

* We will start by using csv files to decide on the format of our game (the shape of the enemies track): 1's will represent the track and 0's will represent the places where we will put the towers. A pro is that it makes generating new tracks very easy by just changing numbers in a csv file. The con is that it constrain our ability to generate rounder types of tracks as we are using a rectangle grid.

* We plan on using property files for each level of the game to specify the towers that will be available, number of enemies, number of lives, csv file path that contains the track shape, size of the grid (ex: nxn). A pro is that it is easier to specify all information for a level in one file. A con is that every time we want a new level we need to create a new property file.

* We plan on using a grid to represent the overall game. Some of the grid rectangles would be the track where the enemy will go through and others will be the places where the towers can be placed. A pro is that it will be easier to place the towers only on specific places. A con is that it decreases the flexibility of where the towers can be placed.
 

