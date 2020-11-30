## Team

Colin Boccaccio, Emily Mittleman, Kenneth Marenco, Luisa Silva and William Clark


## Roles

### Colin

### Emily

### Kenneth

### Luisa

* Created start scene, track option scene and game scene as well as their respectives classes and setting their layout by creating css stylesheets for each scene.
* Created all buttons including: start, begin, pause/resume, next round, quit, tracks buttons, and speed slider.
* Created Button panel class to add buttons, slider and lives display to upper part of the game.
* Created level and bank display as well as integrated it with the backend part of the code.
* Created the tower's panel as well as their interactive features: sprite animation of each tower after clicking on tower button, range around tower and alerts to make sure user was placing tower in correct place (not on top of tracks or panels).
* Created tower upgrade feature (shooting range and speed upgrades) and integrated it with backend part of the code.
* Created alertView class so that exceptions for missing files would be thrown as alerts for the user on the view part of the code.
* Created all the paths for different tracks.
* Created start methods for each stage (start, track option and game) on Controller.
* Created ViewException to deal with exceptions on the view part of the code.
* Created tests for all the view classes.

### William


## Design Goals

what are the project's design goals, specifically what kinds of new features did you want to make easy to add

## High-Level Design

Our Game follows the MVC coding style where we have the Model classes that take care of the backend portion of the project such as  creating bubbles, creating the backend part of the towers(shooting speed, range of shooting, price, location, projectile type and projectiles per shot), creating projectile motion, creating bubble paths with coordinate values, keeping track of bubble's movement and also taking care of all the bank and score display (keeping track of lives, current level, current money). The view is the part of the project that takes care of everything the user can see in the game. That includes the starting scene, the track option scene, the game scene with the bubbles, the path, the background, the upper button panel and the score display (displaying lives, current level and current money in bank). In addition, it also takes care of all the display of towers including the tower panel, the range display, the tower moving with the cursor, the tower sprite animation and the tower upgrade options, the view also reads all the css file styling sheets. Last but not least, the controller takes care of reading files for the backend as well as starting the game and connecting the view and the model by calling a step function that updates both at all times at constant rate.

## Assumptions

* We assumed every time a user wants to add a new track he needs to reause one of the track buttons or create a new one by extending the buttons superclass and adding the button to the option track scene.

* We assumed the tracks will be have their coordinates inputted in a property file located in data->GameConfigurations-> Level -> PathConfigurations and that the file we read from a .txt file.

* We assumed the initial configuration of the bank and the end of round income will be defined in the data->GameConfigurations->Bank -> defaultBank which is a property file.

* We assumed bubble properties such as size and resistance will be. chosen in a property file located in data->GameConfigurations->Bubble-> BubbleTypes.

* We assumed the bubble waves will be specified on a txt file located in data->GameConfigurations-> Level->WaveConfigurations, for which each line represents a different wave and. bubbles are specified by their name.

* To add a new button one just need to extend the Buttons superclass and add it to the buttonPanel in the ButtonPanel class


## Plan Differences
address significant differences between the original plan and the final version of the project

## Adding New Features
describe, in detail, how to add new features to your project, especially ones you were not able to complete by the deadline
