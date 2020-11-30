# OOGA Lab Discussion
## Names and NetIDs
Quintuple Responsibility Principle:
William Clark, whc10, Kenneth Marenco, kem78, Emily Mittleman, elm66, Luisa Silva, lps23, Colin Boccaccio, cmb171


## Fluxx

### High Level Design Ideas


### CRC Card Classes

Rules Super Class, and subclasses that override the rules method
This class's purpose or value is to manage something:
```java
 public class Rules {
     private int cardsToDraw;
     private int cardsToPlay;
     private Set<WinCondition> allPossibleWinConditions;
     private WinCondition currentWinCondition;
     public int getNumberOfCardsToPlay();
     public int setNumberOfCardsToPlay();
     public int getNumberOfCardsToDraw();
     public int setNumberOfCardsToDraw();
     public int getWinConditions();
     public int setWinCondition();
     public int getWinCondition();

}
```

This class's purpose or value is to be useful:
```java
 public abstract class Card {
     public abstract playCard();
     public abstract getType();
     public abstract getSubject();
 }
```

### Use Cases
Player plays a Goal card, changes the goal, and wins the game

Card.playCard()
Rules.setWinConditions()
Player.checkWinningPositions()


