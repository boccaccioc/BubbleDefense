final
====

This project implements a player for multiple related games.

Names: Luisa Silva, Emily Mittleman, Colin Boccaccio, Liam Clark, Kenneth Marenco


### Timeline

Start Date: October 23rd, 2020

Finish Date: November 18th, 2020

Hours Spent: 300?

### Primary Roles


### Resources Used


### Running the Program

To run the program, begin with running the program from Main (the controller class with give the same outcome). You will be shown the opening splash screen for Bubble Defense where you can press the start button in the center of the screen to begin. This will lead to a new screen where you have the option of what level you wish to play (there are only 3 currently, but many more can be easily added!). Once you have selected your level, you will see a vertical flowpane which holds all the towers. Click on one of these towers to purchase it and click again somewhere are the field (off the path) to place it. Make sure you have enough money in your bank to purchase the tower which can be found in the upper-right portion of the screen. After placing your towers, you are ready to play! Click the begin button on the upper-left side of the screen to start the game (there's a pause button right next to it if you need to take a break). The begin button with send a wave of enemies (in this case bubbles) for you to destroy. At the end of each wave, you will have time to buy new towers with your newly earned cash! When you are ready to begin the next wave, click the next round button. If you get tired of this map and want to play a new one, click the quit button to go back to the level selection menu. 

Main class:

Data files needed: Property files, .txt extension files, and .png extension files in the GameConfiguration resource file are required to run the game. The images, sprites, and Tracks Directory are needed for all the objects and backgrounds to have images.

* Bank Directory

Contains the bank property files that are used to dictate the passive amount of money earned and what is earned for finishing each round and popped enemies.

* Enemy Directory

Contains a property file holding the locations of the different enemies types. Within the directory is a subdirectory of property files containing all the necessary information needed to give characteristics to each enemy type.

* Level Directory

The level property files in this directory give files names for what wave and path are desired for that particular level. There are subdirectories named PathConfiguration and WaveConfiguration where .txt files are held that contain the information needed to change the pathing for each enemy per wave. 


* images Directory

Contains the pngs used for the bubble objects and the tower objects.

* sprites Directory

Contains the pngs used for giving animation to the towers.


Features implemented:



### Notes/Assumptions

Assumptions or Simplifications: 

* Only 3 levels are assumed to be shown
 
It is assumed that the number of levels desired is already known, so while creating new levels with new enemy waves and new paths is an easy task by adding new property files, only 3 levels are going to be shown.



Interesting data files:

Known Bugs:

Extra credit:


### Impressions

"# BubbleDefense" 
