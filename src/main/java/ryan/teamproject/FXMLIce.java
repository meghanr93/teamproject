package ryan.teamproject;

/*
Charley Treen
December 2021 + January 2022
A one player fishing game.
Player uses fishing pole ("AncPole") to collect fish and avoid jellyfish. 
Cameras are collected on ice with no value.

Attached to a colour memory game and frogger game.
 */
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static ryan.teamproject.MainApp.setRoot;
//import static ryan.teamproject.MainApp.setRoot;

public class FXMLIce implements Initializable {

    boolean run = false;
    int directionY = 0;
    int directionX = 0;
//80, 80 and 120 are the speeds of the objects
    Timeline camerastime = new Timeline(new KeyFrame(Duration.millis(80), ae -> moveCamera()));
    Timeline fishtime = new Timeline(new KeyFrame(Duration.millis(80), ae -> moveFish()));
    Timeline jellyfishtime = new Timeline(new KeyFrame(Duration.millis(120), ae -> moveJellyfish()));
   
    @FXML
    private Button btnhh, btnClose,btnCloset;
    @FXML
    private AnchorPane AncFishone, AncFishtwo, AncFishthr, AncFishfour, AncFishFive, AncFishten, AncFishnine, AncFishsev, AncFisheigh, AncFishSix,
            AncJellyfour, AncJellyone, AncJellytwo, AncJellythr, AncCamfive, AncCamthr, AncCamtwo, AncCamfou, AncCamone, AncCameig, AncCamsev, AncCamsix, AncPole, AncPreStart,
            Anchh;
    @FXML
    private Rectangle RecFishpole;

    @FXML
    private Rectangle recWallr, recWallt, recWalll, recWallb;

    @FXML
    private Label lblCooler, lblWinLoss, lblWins;

    @FXML
    private Arc ArcFishnin, ArcFishtwen, ArcFishfou, ArcFishsixt, ArcFisheighte, ArcFishele, ArcFishfif, ArcFishthi, ArcFishseve, ArcFishtwe;

    @FXML
    private Button btnTools, btnExit, btnRest, btnPlay, btnExitga, btnPlayAgain;
//arrays
    AnchorPane fish[];
    AnchorPane jellyfish[];
    AnchorPane cameras[];
    //score and win count
    int score = 0;
    int wins = 0;
    //movement for objects
    int fish1X = -10;
    int fish2X = -10;
    int fish3X = -10;
    int fish4X = -10;
    int fish5X = -10;
    int fish6X = -10;
    int fish7X = -10;
    int fish8X = -10;
    int fish9X = -10;
    int fish10X = -10;
    int camera5X = -10;
    int camera6X = -10;
    int camera7X = -10;
    int camera8X = -10;
    int jellyfish1X = -10;
    int jellyfish2X = -10;
    int jellyfish3X = -10;
    int jellyfish4X = -10;

    @FXML
    void btnRest(ActionEvent event) {
        //reset method
        //sets objects visible and invisible
        AncPreStart.setVisible(true);
        AncPole.setDisable(true);
        btnTools.setDisable(false);
        btnTools.setVisible(true);
         btnhh.setVisible (false);
         btnCloset.setVisible (false);
        btnClose.setVisible (false);
        Anchh.setVisible (false);
        btnExit.setVisible(false);
        btnRest.setVisible(false);
        btnPlayAgain.setVisible(false);
        btnPlay.setVisible(true);
        //timers of objects
        camerastime.setCycleCount(Timeline.INDEFINITE);
        camerastime.stop();
        fishtime.setCycleCount(Timeline.INDEFINITE);
        fishtime.stop();
        jellyfishtime.setCycleCount(Timeline.INDEFINITE);
        jellyfishtime.stop();


        /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
        for (AnchorPane name : fish) {
            name.setDisable(true);
        }

        /* creates an array of all the fish listed, makes them all 
      identified as "jellyfish" */
        for (AnchorPane name : jellyfish) {
            name.setDisable(true);
        }

        /* creates an array of all the cameras listed, makes them all 
      identified as "cameras" */
        for (AnchorPane name : cameras) {
            name.setDisable(true);
        }
    }

    @FXML
    void btnPlayAgain(ActionEvent event) {
        //play again method
        //sets objects visible and invisible
        ArcFishnin.setVisible(false);
        ArcFishtwen.setVisible(false);
        ArcFishfou.setVisible(false);
        ArcFishsixt.setVisible(false);
        ArcFisheighte.setVisible(false);
        ArcFishele.setVisible(false);
        ArcFishfif.setVisible(false);
        ArcFishthi.setVisible(false);
        ArcFishseve.setVisible(false);
        ArcFishtwe.setVisible(false);
        AncCamthr.setVisible(false);
        AncCamtwo.setVisible(false);
        AncCamfou.setVisible(false);
        AncCamone.setVisible(false);
        ArcFishnin.setVisible(false);
        AncFishone.setVisible(true);
        AncFishtwo.setVisible(true);
        AncFishthr.setVisible(true);
        AncFishfour.setVisible(true);
        AncFishFive.setVisible(true);
        AncFishSix.setVisible(true);
        AncFishsev.setVisible(true);
        AncFisheigh.setVisible(true);
        AncFishnine.setVisible(true);
        AncFishten.setVisible(true);
        AncCamfive.setVisible(true);
        AncCamsix.setVisible(true);
        AncCamsev.setVisible(true);
        AncCameig.setVisible(true);
        AncPreStart.setVisible(false);
        AncPole.setDisable(false);
        btnRest.setVisible(false);
        btnExit.setVisible(false);
        btnTools.setVisible(true);
        //runs timer
        run = true;
        //sets score back to zero for new game
        score = 0;
        lblCooler.setText("" + score);
        //timers length of time to run
        camerastime.setCycleCount(Timeline.INDEFINITE);
        camerastime.play();
        fishtime.setCycleCount(Timeline.INDEFINITE);
        fishtime.play();
        jellyfishtime.setCycleCount(Timeline.INDEFINITE);
        jellyfishtime.play();
        //allows tools to be pressed for exit and restart buttons
        btnTools.setDisable(false);
         btnhh.setVisible (false);
        btnClose.setVisible (false);
        Anchh.setVisible (false);
        //turns pole red for restart (not being struck by jellyfish)
        RecFishpole.setFill(Color.RED);
        AncPole.requestFocus();
        /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
        for (AnchorPane name : fish) {
            name.setDisable(true);
        }

        /* creates an array of all the fish listed, makes them all 
      identified as "jellyfish" */
        for (AnchorPane name : jellyfish) {
            name.setDisable(true);
        }

        /* creates an array of all the cameras listed, makes them all 
      identified as "cameras" */
        for (AnchorPane name : cameras) {
            name.setDisable(true);
        }
    }

    @FXML
    void btnTools(MouseEvent event) {
        btnExit.setVisible(true);
        btnRest.setVisible(true);
         btnhh.setVisible (true);
    btnTools.setVisible (false);
    btnCloset.setVisible (true);
    }

    @FXML
    void btnExitga(ActionEvent event) throws IOException {
        //sends to exit screen
      MainApp.setRoot("endscreen");
    }

    @FXML
    void AncPole(KeyEvent event) throws IOException {
        directionX = 0;
        directionY = 0;

        if (event.getCode() == KeyCode.S) {
            //moves control down
            directionX = 0;
            directionY = 10;
        }

        if (event.getCode() == KeyCode.W) {
            //moves control up
            directionX = 0;
            directionY = -10;
        }

        AncPole.setTranslateY(AncPole.getTranslateY() + directionY);

        if (collision(recWallt, AncPole)) {
            AncPole.setTranslateY(AncPole.getTranslateY() - directionY);
        }

        if (collision(recWallb, AncPole)) {
            AncPole.setTranslateY(AncPole.getTranslateY() - directionY);
        }

        if (collision(AncFishone, AncPole) && AncFishone.isVisible()) {
            ArcFishnin.setVisible(true);
            AncFishone.setVisible(false);
            //makes fish disappear in water and "reappear" on ice
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
        }

        if (collision(AncFishtwo, AncPole) && AncFishtwo.isVisible()) {
            ArcFishtwen.setVisible(true);
            AncFishtwo.setVisible(false);
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncFishthr, AncPole) && AncFishthr.isVisible()) {
            ArcFishele.setVisible(true);
            AncFishthr.setVisible(false);
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncFishfour, AncPole) && AncFishfour.isVisible()) {
            ArcFisheighte.setVisible(true);
            AncFishfour.setVisible(false);
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncFishFive, AncPole) && AncFishFive.isVisible()) {
            ArcFishtwe.setVisible(true);
            AncFishFive.setVisible(false);
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncFishSix, AncPole) && AncFishSix.isVisible()) {
            ArcFishsixt.setVisible(true);
            AncFishSix.setVisible(false);
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncFishsev, AncPole) && AncFishsev.isVisible()) {
            ArcFishseve.setVisible(true);
            AncFishsev.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncFisheigh, AncPole) && AncFisheigh.isVisible()) {
            ArcFishfif.setVisible(true);
            AncFisheigh.setVisible(false);
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncFishnine, AncPole) && AncFishnine.isVisible()) {
            ArcFishfou.setVisible(true);
            AncFishnine.setVisible(false);
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncFishten, AncPole) && AncFishten.isVisible()) {
            ArcFishthi.setVisible(true);
            AncFishten.setVisible(false);
            //adds fish number +1
            score++;
            lblCooler.setText("" + score);
            //checks if fish is 10
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncCamfive, AncPole)) {

            AncCamone.setVisible(true);
            AncCamfive.setVisible(false);
        } //makes camera disappear in water and "reappear" on ice

        if (collision(AncCamsix, AncPole)) {

            AncCamtwo.setVisible(true);
            AncCamsix.setVisible(false);
//makes camera disappear in water and "reappear" on ice
        }
        if (collision(AncCamsev, AncPole)) {

            AncCamthr.setVisible(true);
            AncCamsev.setVisible(false);

//makes camera disappear in water and "reappear" on ice
        }
        if (collision(AncCameig, AncPole)) {

            AncCamfou.setVisible(true);
            AncCameig.setVisible(false);
//makes camera disappear in water and "reappear" on ice

        }

        if (collision(AncJellyone, AncPole)) {
            //makes fishing pole strcuk by jellyfish
            RecFishpole.setFill(Color.BLACK);
            //stops timers
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            //makes control not moveable
            AncPole.setDisable(true);
            lblWinLoss.setText("You Lost!");
            AncPreStart.setVisible(true);
            btnPlay.setVisible(false);
            btnPlayAgain.setVisible(true);
            btnPlay.setVisible(false);

            //makes pole turn black when hit by jellyfish, loss method
        }

        if (collision(AncJellytwo, AncPole)) {
            //makes fishing pole strcuk by jellyfish
            RecFishpole.setFill(Color.BLACK);
            //stops timers
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            lblWinLoss.setText("You Lost!");
            //makes control not moveable
            AncPole.setDisable(true);
            AncPreStart.setVisible(true);
            btnPlay.setVisible(false);
            btnPlayAgain.setVisible(true);
            btnPlay.setVisible(false);

            //makes pole turn black when hit by jellyfish, loss method
        }
        if (collision(AncJellythr, AncPole)) {
            //makes fishing pole strcuk by jellyfish
            RecFishpole.setFill(Color.BLACK);
            //stops timers
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            lblWinLoss.setText("You Lost!");
            //makes control not moveable
            AncPole.setDisable(true);
            AncPreStart.setVisible(true);
            btnPlay.setVisible(false);
            btnPlayAgain.setVisible(true);
            btnPlay.setVisible(false);

            //makes pole turn black when hit by jellyfish, loss method
        }
        if (collision(AncJellyfour, AncPole)) {
            //makes fishing pole strcuk by jellyfish
            RecFishpole.setFill(Color.BLACK);
            //stops timers
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            lblWinLoss.setText("You Lost!");
            //makes control not moveable
            AncPole.setDisable(true);
            AncPreStart.setVisible(true);
            btnPlay.setVisible(false);
            btnPlayAgain.setVisible(true);
            btnPlay.setVisible(false);

        }
    }

    public boolean collision(AnchorPane block1, AnchorPane block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    private void moveCamera() {
        AncCamfive.setTranslateX(AncCamfive.getTranslateX() + camera5X);
        AncCamsix.setTranslateX(AncCamsix.getTranslateX() + camera6X);
        AncCamsev.setTranslateX(AncCamsev.getTranslateX() + camera7X);
        AncCameig.setTranslateX(AncCameig.getTranslateX() + camera8X);

        if (collision(AncCamfive, recWallr)) {
            camera5X = -10;
        }

        if (collision(AncCamfive, recWalll)) {
            camera5X = 10;
        }

        if (collision(AncCamsix, recWallr)) {
            camera6X = -10;
        }
        if (collision(AncCamsix, recWalll)) {
            camera6X = 10;
        }
        if (collision(AncCamsev, recWallr)) {
            camera7X = -10;
        }
        if (collision(AncCamsev, recWalll)) {
            camera7X = 10;
        }
        if (collision(AncCameig, recWallr)) {
            camera8X = -10;
        }
        if (collision(AncCameig, recWalll)) {
            camera8X = 10;
        }
    }

    public boolean collision(Rectangle block1, AnchorPane block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    private void moveFish() {

        AncFishone.setTranslateX(AncFishone.getTranslateX() + fish1X);
        AncFishtwo.setTranslateX(AncFishtwo.getTranslateX() + fish2X);
        AncFishthr.setTranslateX(AncFishthr.getTranslateX() + fish3X);
        AncFishfour.setTranslateX(AncFishfour.getTranslateX() + fish4X);
        AncFishFive.setTranslateX(AncFishFive.getTranslateX() + fish5X);
        AncFishSix.setTranslateX(AncFishSix.getTranslateX() + fish6X);
        AncFishsev.setTranslateX(AncFishsev.getTranslateX() + fish7X);
        AncFisheigh.setTranslateX(AncFisheigh.getTranslateX() + fish8X);
        AncFishnine.setTranslateX(AncFishnine.getTranslateX() + fish9X);
        AncFishten.setTranslateX(AncFishten.getTranslateX() + fish10X);
        if (collision(AncFishone, recWallr)) {
            fish1X = -10;
            AncFishone.setRotationAxis(new Point3D(0, 90, 1));
            AncFishone.setRotate(0);
        }

        if (collision(AncFishone, recWalll)) {
            fish1X = 10;
            AncFishone.setRotationAxis(new Point3D(0, 90, 1));
            AncFishone.setRotate(180);
        }

        if (collision(AncFishtwo, recWallr)) {
            fish2X = -10;
            AncFishtwo.setRotationAxis(new Point3D(0, 90, 1));
            AncFishtwo.setRotate(0);
        }

        if (collision(AncFishtwo, recWalll)) {
            fish2X = 10;
            AncFishtwo.setRotationAxis(new Point3D(0, 90, 1));
            AncFishtwo.setRotate(180);
        }

        if (collision(AncFishthr, recWallr)) {
            fish3X = -10;
            AncFishthr.setRotationAxis(new Point3D(0, 90, 1));
            AncFishthr.setRotate(0);
        }

        if (collision(AncFishthr, recWalll)) {
            fish3X = 10;
            AncFishthr.setRotationAxis(new Point3D(0, 90, 1));
            AncFishthr.setRotate(180);
        }

        if (collision(AncFishfour, recWallr)) {
            fish4X = -10;
            AncFishfour.setRotationAxis(new Point3D(0, 90, 1));
            AncFishfour.setRotate(0);
        }

        if (collision(AncFishfour, recWalll)) {
            fish4X = 10;
            AncFishfour.setRotationAxis(new Point3D(0, 90, 1));
            AncFishfour.setRotate(180);
        }

        if (collision(AncFishFive, recWallr)) {
            fish5X = -10;
            AncFishFive.setRotationAxis(new Point3D(0, 90, 1));
            AncFishFive.setRotate(0);
        }

        if (collision(AncFishFive, recWalll)) {
            fish5X = 10;
            AncFishFive.setRotationAxis(new Point3D(0, 90, 1));
            AncFishFive.setRotate(180);
        }

        if (collision(AncFishSix, recWallr)) {
            fish6X = -10;
            AncFishSix.setRotationAxis(new Point3D(0, 90, 1));
            AncFishSix.setRotate(0);
        }

        if (collision(AncFishSix, recWalll)) {
            fish6X = 10;
            AncFishSix.setRotationAxis(new Point3D(0, 90, 1));
            AncFishSix.setRotate(180);
        }

        if (collision(AncFishsev, recWallr)) {
            fish7X = -10;
            AncFishsev.setRotationAxis(new Point3D(0, 90, 1));
            AncFishsev.setRotate(0);
        }

        if (collision(AncFishsev, recWalll)) {
            fish7X = 10;
            AncFishsev.setRotationAxis(new Point3D(0, 90, 1));
            AncFishsev.setRotate(180);
        }

        if (collision(AncFisheigh, recWallr)) {
            fish8X = -10;
            AncFisheigh.setRotationAxis(new Point3D(0, 90, 1));
            AncFisheigh.setRotate(0);
        }

        if (collision(AncFisheigh, recWalll)) {
            fish8X = 10;
            AncFisheigh.setRotationAxis(new Point3D(0, 90, 1));
            AncFisheigh.setRotate(180);
        }

        if (collision(AncFishnine, recWallr)) {
            fish9X = -10;
            AncFishnine.setRotationAxis(new Point3D(0, 90, 1));
            AncFishnine.setRotate(0);
        }

        if (collision(AncFishnine, recWalll)) {
            fish9X = 10;
            AncFishnine.setRotationAxis(new Point3D(0, 90, 1));
            AncFishnine.setRotate(180);
        }

        if (collision(AncFishten, recWallr)) {
            fish10X = -10;
            AncFishten.setRotationAxis(new Point3D(0, 90, 1));
            AncFishten.setRotate(0);
        }

        if (collision(AncFishten, recWalll)) {
            fish10X = 10;
            AncFishten.setRotationAxis(new Point3D(0, 90, 1));
            AncFishten.setRotate(180);
        }
    }

    public boolean collision(AnchorPane block1, Rectangle block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    private void moveJellyfish() {
        AncJellyone.setTranslateX(AncJellyone.getTranslateX() + jellyfish1X);
        AncJellytwo.setTranslateX(AncJellytwo.getTranslateX() + jellyfish2X);
        AncJellythr.setTranslateX(AncJellythr.getTranslateX() + jellyfish3X);
        AncJellyfour.setTranslateX(AncJellyfour.getTranslateX() + jellyfish4X);

        if (collision(AncJellyone, recWallr)) {
            jellyfish1X = -10;
        }

        if (collision(AncJellyone, recWalll)) {
            jellyfish1X = 10;
        }

        if (collision(AncJellytwo, recWallr)) {
            jellyfish2X = -10;
            AncJellytwo.setRotationAxis(new Point3D(0, 90, 1));
            AncJellytwo.setRotate(180);
        }

        if (collision(AncJellytwo, recWalll)) {
            jellyfish2X = 10;
            AncJellytwo.setRotationAxis(new Point3D(0, 90, 1));
            AncJellytwo.setRotate(0);
        }

        if (collision(AncJellythr, recWallr)) {
            jellyfish3X = -10;
        }

        if (collision(AncJellythr, recWalll)) {
            jellyfish3X = 10;
        }

        if (collision(AncJellyfour, recWallr)) {
            jellyfish4X = -10;

        }
        if (collision(AncJellyfour, recWalll)) {
            jellyfish4X = 10;
        }
    }

    void checkWin() throws IOException {
        if (score == 10) {
            //win method runs if score is 10 fish 
            for (AnchorPane name : fish) {
                name.setDisable(true);
            }
            for (AnchorPane name : jellyfish) {
                name.setDisable(true);

            }
            for (AnchorPane name : cameras) {
                name.setDisable(true);
            }
            AncPole.setDisable(true);
            //turns timers off
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            //adds +1 to number of wins
            wins++;
            lblWinLoss.setVisible(true);
            lblWinLoss.setText("You Won!");
            //sets label with umber of wins
            lblWins.setText("" + wins);
            AncPole.setDisable(true);
            AncPreStart.setVisible(true);
            btnPlay.setVisible(false);
            btnPlayAgain.setVisible(true);
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnPlay(ActionEvent event) {
        //starts timers when you press play
        AncPreStart.setVisible(false);
        AncPole.setDisable(false);
        //runs movement
        run = true;
        //sets score back to zero for new game
        score = 0;
        lblCooler.setText("" + score);
        //plays timers
        camerastime.setCycleCount(Timeline.INDEFINITE);
        camerastime.play();
        fishtime.setCycleCount(Timeline.INDEFINITE);
        fishtime.play();
        jellyfishtime.setCycleCount(Timeline.INDEFINITE);
        jellyfishtime.play();
        btnTools.setDisable(false);
        //turns pole back to jellyfish incase not red, not struck by jellyfish anymore
        RecFishpole.setFill(Color.RED);
        AncPole.requestFocus();
        //sets collected cameras invisible if not already
        AncCamthr.setVisible(false);
        AncCamtwo.setVisible(false);
        AncCamfou.setVisible(false);
        AncCamone.setVisible(false);
    }

    /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
    
     @FXML
    void btnhh(ActionEvent event) {
Anchh.setVisible (true);
btnClose.setVisible (true);
btnhh.setVisible (false);
    }
        @FXML
    void btnClose(ActionEvent event) {
Anchh.setVisible (false);
btnhh.setVisible (true);
btnClose.setVisible (false);
btnTools.setVisible (true);
    }
        @FXML
    void btnCloset(ActionEvent event) {
btnTools.setVisible (true);
     btnExit.setVisible(false);
        btnRest.setVisible(false);
         btnhh.setVisible (false);
         btnCloset.setVisible (false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnTools.setDisable(true);
        btnTools.setVisible (true);
        btnhh.setVisible (false);
        btnClose.setVisible (false);
        btnCloset.setVisible (false);
        Anchh.setVisible (false);
        btnExit.setVisible(false);
        btnRest.setVisible(false);
        AncPreStart.setVisible(true);
        AncPole.setDisable(true);
        btnPlayAgain.setVisible(false);
        btnPlay.setVisible(true);
        //array of fish
        AnchorPane temp[] = {AncFishone, AncFishtwo, AncFishthr, AncFishfour, AncFishFive,
            AncFishsev, AncFisheigh, AncFishnine, AncFishten};
        fish = temp;
        //array of jellyfish
        AnchorPane temp1[] = {AncJellyone, AncJellytwo, AncJellythr, AncJellyfour};
        jellyfish = temp1;
        //array of cameras
        AnchorPane temp2[] = {AncCamfive, AncCamsix, AncCamsev, AncCameig};
        cameras = temp2;
        //sets fish collected in cooler invisible to be collected again
        ArcFishnin.setVisible(false);
        ArcFishtwen.setVisible(false);
        ArcFishfou.setVisible(false);
        ArcFishsixt.setVisible(false);
        ArcFisheighte.setVisible(false);
        ArcFishele.setVisible(false);
        ArcFishfif.setVisible(false);
        ArcFishthi.setVisible(false);
        ArcFishseve.setVisible(false);
        ArcFishtwe.setVisible(false);
        //set cameras on ice back to start to be collected again
        AncCamthr.setVisible(false);
        AncCamtwo.setVisible(false);
        AncCamfou.setVisible(false);
        AncCamone.setVisible(false);
        for (AnchorPane name : fish) {
            name.setDisable(true);
        }


        /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
        for (AnchorPane name : jellyfish) {
            name.setDisable(true);
        }


        /* creates an array of all the cameras listed, makes them all 
      identified as "cameras" */
        for (AnchorPane name : cameras) {
            name.setDisable(true);
            //disables timer for cameras movement
        }
    }
}
    

// music didn't work out with youtube to mp3 conversion (activated the firewall)
