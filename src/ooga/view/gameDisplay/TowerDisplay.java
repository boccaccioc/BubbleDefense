package ooga.view.gameDisplay;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import ooga.model.Model;
import ooga.model.Player;
import ooga.model.tower.Tower;
import ooga.view.Alert.AlertView;
import ooga.view.GameView;
import ooga.view.exceptions.ViewException;

/**
 * TowerDisplay class deals with the creation of the side pane containing the tower's images,
 * adding towers to the borderpane where the track and bubbles are located, upgrading towers
 * by their range and projectile speed and creating the sprite animation after towers are placed
 * on the game.
 *
 * @author - Luisa Silva
 */
public class TowerDisplay {

  private static final String TOWER_ON_PATH_ALERT = "Can't place tower on path.";
  private static final String UPGRADE_MY_TOWER = "Upgrade my tower";
  private static final String CHOOSE_YOUR_UPGRADE_TYPE = "Choose your upgrade type:";
  private static final String DEFAULT_CHOICE = "None";
  private static final String SHOOTING_SPEED = "Shooting Speed x 1.2";
  private static final String RANGE = "Range x 1.2";
  private static final String SKIP_LINE = "\n";
  private static final String INCREASE_SHOOTING_SPEED = "Increase Shooting Speed: $";
  private static final String INCREASE_RANGE = "Increase Range: $";
  private static final String TOWER_OUT_OF_BOUNDS = "Can't place tower out of screen.";
  private static int UPGRADE_PRICE_SPEED = 100;
  private static int UPGRADE_PRICE_RANGE = 100;
  private static final double UPGRADE_MULTIPLIER = 1.2;
  private static final String MONEY_UPGRADE_ALERT = "Don't have enough money for upgrade. Pop more bubbles!";
  private static final String TOWER_MONEY_ALERT = "You don't have enough money. Pop more bubbles!";

  private FlowPane flow;
  private final BorderPane border;
  private final GameView view;
  private final AlertView alertView = new AlertView();
  private final Model model;
  private static final int PADDING_TOP =5;
  private static final String FLOW_PANE_ID = "flow";
  private static final int PADDING_BOTTOM =5;
  private static final int PADDING_LEFT =0;
  private static final int PADDING_RIGHT =0;
  private static final int VERTICAL_GAP =4;
  private static final int HORIZONTAL_GAP =4;
  private static final int WRAP_LENGTH =150;

  private static final int NUMBER_OF_TOWERS =5;
  private static final Dimension TOWER_SIZE = new Dimension(110, 90);
  private static final Dimension BUTTON_SIZE = new Dimension(165, 80);
  private static final String DOLLAR_SIGN = "$";
  private static final String TOWER_BUTTONS_ID = "TowerButtons";
  private static final String TOWER_HEADLINE_ID = "TowerHeadline";
  private static final String TOWER_RANGE_ID = "TowerRange";

  private static final double CENTER_ADJUSTMENT = 50.0;

  private static final String TOWER_LABEL = " TOWERS";

  private static final int CONSTANT_ONE =1;
  private static final int CONSTANT_TWO =2;
  private static final int ANIMATION_DURATION =2500;
  private static final String PNG_EXTENSION = ".png";
  private static final String DOT_EXTENSION = ".";
  private static final String SPRITE_PATH = "data/sprites/sprite";
  private static final List<String> POTENTIAL_UPGRADES = List.of(SHOOTING_SPEED, RANGE);

  private final List<Tower> towers;

  private final Player player;

  private final Map<String, String> towerIdToType = Map.of("1", "Goldfish",
                                                    "2", "Pufferfish",
                                                    "3", "Octopus",
                                                    "4", "Seahorse",
                                                    "5", "Submarine");


  /**
   * @param border - main borderPane where game happens
   * @param view - Gameview object
   * @param model - Model object
   * @param towers - tower list of all possible towers we can place on the borderpane
   * @param player - player object created in Model part of the project
   */
  public TowerDisplay(BorderPane border, GameView view, Model model,
      List<Tower> towers, Player player){
    this.view = view;
    this.border= border;
    this.model = model;
    this.towers = towers;
    this.player = player;
  }

  /**
   * @return - Flowpane object that contains all buttons with tower images that can be placed
   * on the borderPane.
   */
  public FlowPane addFlowPane() {
    flow = new FlowPane();
    flow.setPadding(new Insets(PADDING_TOP, PADDING_LEFT, PADDING_BOTTOM, PADDING_RIGHT));
    flow.setVgap(VERTICAL_GAP);
    flow.setHgap(HORIZONTAL_GAP);
    flow.setPrefWrapLength(WRAP_LENGTH);
    flow.setId(FLOW_PANE_ID);
    createTowerHeadlineText(flow);
    createTowerButtons(flow);
    return flow;
  }

  private void createTowerHeadlineText(FlowPane flow) {
    Text t = new Text(TOWER_LABEL);
    t.setId(TOWER_HEADLINE_ID);
    flow.getChildren().add(t);
  }


  private void createTowerButtons(FlowPane flow) {
    Button[] button = new Button[NUMBER_OF_TOWERS];
    for (int i=0; i<NUMBER_OF_TOWERS; i++) {
      Tower tower = towers.get(i);
      button[i] = new Button(DOLLAR_SIGN+tower.getPrice());   // where we will change the prices
      button[i].setId(TOWER_BUTTONS_ID);
      button[i].setPrefSize(BUTTON_SIZE.width, BUTTON_SIZE.height);
      setTowerImageOnButton(button[i], i);

      int finalI = i;
      button[i].setOnMouseClicked(e-> {
        createAnimatedTower(finalI, tower);
      });

      button[i].setId(TOWER_BUTTONS_ID);
      flow.getChildren().add(button[i]);
    }
  }

  private void createAnimatedTower(int finalI, Tower tower) {
    if(player.canAffordTower(tower)) {
      player.purchaseTower(tower);
      ImageView towerImage = new ImageView();
      List<Image> image_list = createSpriteList(finalI + CONSTANT_ONE);
      Transition tower_animation = createSpriteAnimation(towerImage, image_list);
      tower_animation.play();
      Circle range = createRangeOnTower(tower);
      towerImage.setId(String.valueOf(finalI + CONSTANT_ONE));
      setTower(towerImage, range, tower);
    }
    else{
      alertView.createAlert(TOWER_MONEY_ALERT);
    }
  }


  /**
   * @param button -Button object
   * @param i - number of the tower that will be added on the button
   */
  public void setTowerImageOnButton(Button button, int i) {
    ImageView img= null;
    try {
      img = new ImageView(new Image(new FileInputStream(SPRITE_PATH+(i+CONSTANT_ONE)
          +DOT_EXTENSION+CONSTANT_ONE+PNG_EXTENSION)));
    } catch (FileNotFoundException e) {
      throw new ViewException("FileNotFound");
    }
    img.setFitHeight(TOWER_SIZE.height);
    img.setFitWidth(TOWER_SIZE.width);
    button.setGraphic(img);
  }

  /**
   * @param i - number of the tower to create the sprite for
   * @return - a list with all the images for the sprite animation
   */
  public List<Image> createSpriteList(int i) {
    List<Image> images = new ArrayList<>();

    try {
      images.add(new Image(new FileInputStream(SPRITE_PATH+i+DOT_EXTENSION
          +CONSTANT_ONE+PNG_EXTENSION)));
    } catch (FileNotFoundException e) {
      throw new ViewException("FileNotFound");
    }
    try {
      images.add(new Image(new FileInputStream(SPRITE_PATH+i+DOT_EXTENSION
          +CONSTANT_TWO+PNG_EXTENSION)));
    } catch (FileNotFoundException e) {
      throw new ViewException("FileNotFound");
    }
    try {
      images.add(new Image(new FileInputStream(SPRITE_PATH+i+DOT_EXTENSION
          +CONSTANT_ONE+PNG_EXTENSION)));
    } catch (FileNotFoundException e) {
      throw new ViewException("FileNotFound");
    }
    return images;
  }

  private Transition createSpriteAnimation(ImageView imageView, List<Image> images) {
    return new Transition() {
      {
        setCycleDuration(Duration.millis(ANIMATION_DURATION));
        setCycleCount(Animation.INDEFINITE);
      }

      @Override
      protected void interpolate(double fraction) {
        int index = (int) (fraction*(images.size()-CONSTANT_ONE));
        imageView.setImage(images.get(index));
      }
    };
  }

  private Circle createRangeOnTower(Tower tower) {
    Circle range = new Circle(tower.getRangeRadius()); // change radius according to range of tower
    range.setId(TOWER_RANGE_ID);
    border.getChildren().add(range);
    return range;
  }

  private void setTower(ImageView img, Circle range, Tower tower) {
      img.setFitHeight(TOWER_SIZE.height);
      img.setFitWidth(TOWER_SIZE.width);
      border.getChildren().add(img);
      border.setOnMouseMoved(e -> handleMousePosition(img,e.getX(), e.getY(), range));
      border.setOnMouseClicked(event-> handleMouseInput(event.getX(), event.getY(), img, range, tower));
  }

  private void handleMousePosition(ImageView img, double x, double y, Circle range) {
    img.setX(x-CENTER_ADJUSTMENT);
    img.setY(y-CENTER_ADJUSTMENT);
    range.setCenterX(x);
    range.setCenterY(y);
  }

  private void handleMouseInput(double x, double y, ImageView img, Circle range, Tower tower) {
    if(isTowerOnPath(x,y)){
      alertView.createAlert(TOWER_ON_PATH_ALERT);
    }
    else if(isTowerOutOfRange(x,y)){
      alertView.createAlert(TOWER_OUT_OF_BOUNDS);
    }
    else{
      img.setX(x-CENTER_ADJUSTMENT);
      img.setY(y-CENTER_ADJUSTMENT);
      border.getChildren().remove(range);
      border.setOnMouseMoved(null);
      border.setOnMouseClicked(null);
      model.addTower(img.getX()+CENTER_ADJUSTMENT, img.getY()+CENTER_ADJUSTMENT, towerIdToType.get(img.getId()));
      img.setOnMouseClicked(e3 -> handleUpdateClick(img, tower, range));
    }
  }

  private boolean isTowerOutOfRange(double x, double y) {
    return (x>820 || x<0 || y<100 || y>850);
  }

  private void handleUpdateClick(ImageView img, Tower tower, Circle range){
    view.pauseGame();
    border.getChildren().add(range);
    ChoiceDialog<String> dialog = new ChoiceDialog<>(DEFAULT_CHOICE, POTENTIAL_UPGRADES);
    dialog.setTitle(UPGRADE_MY_TOWER);
    dialog.setHeaderText(INCREASE_SHOOTING_SPEED + UPGRADE_PRICE_SPEED+ SKIP_LINE +
        INCREASE_RANGE + UPGRADE_PRICE_RANGE);
    dialog.setContentText(CHOOSE_YOUR_UPGRADE_TYPE);
    dialog.setOnCloseRequest( e4 -> {
      view.pauseGame();
      border.getChildren().remove(range);
    }
      );

    ImageView sticker = new ImageView(img.getImage());
    sticker.setFitHeight(TOWER_SIZE.height);
    sticker.setFitWidth(TOWER_SIZE.width);
    dialog.setGraphic(sticker);
    
    Optional<String> result = dialog.showAndWait();
    result.ifPresent(letter -> upgrade(letter,tower,range));
  }
  private void upgrade(String letter, Tower tower, Circle range){
    switch(letter){
      case SHOOTING_SPEED: upgradeFiringSpeed(tower);
      case RANGE: upgradeRangeRadius(tower, range);
    }
  }

  /**
   * @param tower - tower that will have its projectile speed upgraded if the player
   *              has enough money.
   */
  public void upgradeFiringSpeed(Tower tower){
    if(player.getBalance()>= UPGRADE_PRICE_SPEED){
      player.decreaseBalance(UPGRADE_PRICE_SPEED);
      tower.setProjectileSpeed((int)(tower.getProjectileSpeed()* UPGRADE_MULTIPLIER));
      UPGRADE_PRICE_SPEED+=100;
    }
    else{
      alertView.createAlert(MONEY_UPGRADE_ALERT);
    }

  }

  /**
   * @param tower -tower that will have its shooting range upgraded if the player
   *               has enough money.
   * @param range - range to be upgraded for visual purpose.
   */
  public void upgradeRangeRadius(Tower tower, Circle range){
    if(player.getBalance()>=UPGRADE_PRICE_RANGE){
      player.decreaseBalance(UPGRADE_PRICE_RANGE);
      range.setRadius(tower.getRangeRadius()*1.2);
      tower.setRangeRadius((int) (tower.getRangeRadius()*UPGRADE_MULTIPLIER));
      UPGRADE_PRICE_RANGE+=100;
    }
    else{
      alertView.createAlert(MONEY_UPGRADE_ALERT);
    }

  }


  private boolean isTowerOnPath(double x, double y){
    return view.getPath().contains(x, y);
  }

}
