package ryan.teamproject;

/*
Charley Treen
December 2021 + January 2022
A one player fishing game.
Collect fish and avoid jellyfish and cameras.
Attached to a colour memory game and frogger game in the Meghan and Charleys Arcade.
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import static ryan.teamproject.MainApp.setRoot;

public class FXMLController implements Initializable {

    boolean run = false;
    int directionY = 0;
    int directionX = 0;
 
    Timeline camerastime = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveCamera()));
    Timeline fishtime = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveFish()));
    Timeline jellyfishtime = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveJellyfish()));
    @FXML
    private AnchorPane AncFishone, AncFishtwo, AncFishthr, AncFishfour, AncFishFive, AncFishten, AncFishnine, AncFishsev, AncFisheigh, AncFishSix,
            AncJellyfour, AncJellyone, AncJellytwo, AncJellythr, AncCamfive, AncCamthr, AncCamtwo, AncCamfou, AncCamone, AncCameig, AncCamsev, AncCamsix, AncPole, AncPreStart;

    @FXML
    private Rectangle RecFishpole;
    @FXML
    private Label lblWins;

    @FXML
    private Rectangle recWallr, recWallt, recWalll, recWallb, recWallpr, recWallpl;

    @FXML
    private Label lblCooler, lblWinLoss;

    @FXML
    private Arc ArcFishnin, ArcFishtwen, ArcFishfou, ArcFishsixt, ArcFisheighte, ArcFishele, ArcFishfif, ArcFishthi, ArcFishseve, ArcFishtwe;

    @FXML
    private Button btnTools, btnExit, btnRest;

    AnchorPane fish[];
    AnchorPane jellyfish[];
    AnchorPane cameras[];
    int score = 0;
    int wins = 0;

    @FXML
    void btnExit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnRest(ActionEvent event) {
        AncPreStart.setVisible(true);
        AncPole.setDisable(true);
        btnTools.setDisable(false);
        btnExit.setVisible(false);
        btnRest.setVisible(false);
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
      identified as "fish" */
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
    }

    @FXML
    void btnExitga(ActionEvent event) throws IOException {
        MainApp.setRoot("start");
        wins = 0;
    }

    @FXML
    void AncPole(KeyEvent event) throws IOException {
        AncPole.setTranslateX(AncPole.getTranslateX() + directionX);
        AncPole.setTranslateY(AncPole.getTranslateY() + directionY);


        if (event.getCode() == KeyCode.D) {
            directionX = 10;
            directionY = 0;
        }

        if (event.getCode() == KeyCode.S) {
            directionX = 0;
            directionY = 10;
        }

        if (event.getCode() == KeyCode.A) {
            directionX = -10;
            directionY = 0;
        }

        if (event.getCode() == KeyCode.W) {
            directionX = 0;
            directionY = -10;
        }
        if (collision(recWallpr, AncPole)) {
               AncPole.setTranslateX(AncPole.getTranslateX() - directionX);
        AncPole.setTranslateY(AncPole.getTranslateY() - directionY);
        }
        if (collision(recWallpl, AncPole)) {
              AncPole.setTranslateX(AncPole.getTranslateX() - directionX);
        AncPole.setTranslateY(AncPole.getTranslateY() - directionY);
        }

        if (collision(recWallt, AncPole)) {
            AncPole.setTranslateX(AncPole.getTranslateX() - directionX);
        AncPole.setTranslateY(AncPole.getTranslateY() - directionY);
        }

        if (collision(recWallb, AncPole)) {
              AncPole.setTranslateX(AncPole.getTranslateX() - directionX);
        AncPole.setTranslateY(AncPole.getTranslateY() - directionY);
        }

        if (collision(AncFishone, AncPole)) {
            ArcFishnin.setVisible(true);
            AncFishone.setVisible(false);
//makes fish disappear in water and "reappear" on ice
            score++;
            lblCooler.setText("" + score);
            checkWin();
        }
        if (collision(AncFishtwo, AncPole)) {
            ArcFishtwen.setVisible(true);
            AncFishtwo.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFishthr, AncPole)) {
            ArcFishele.setVisible(true);
            AncFishthr.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFishfour, AncPole)) {
            ArcFisheighte.setVisible(true);
            AncFishfour.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFishFive, AncPole)) {
            ArcFishtwe.setVisible(true);
            AncFishFive.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFishSix, AncPole)) {
            ArcFishsixt.setVisible(true);
            AncFishSix.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFishsev, AncPole)) {
            ArcFishseve.setVisible(true);
            AncFishsev.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFisheigh, AncPole)) {
            ArcFishfif.setVisible(true);
            AncFisheigh.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFishnine, AncPole)) {
            ArcFishfou.setVisible(true);
            AncFishnine.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFishten, AncPole)) {
            ArcFishthi.setVisible(true);
            AncFishten.setVisible(false);
            score++;
            lblCooler.setText("" + score);
            checkWin();
            //makes fish disappear in water and "reappear" on ice
        }

        if (collision(AncJellyone, AncPole)) {
            RecFishpole.setFill(Color.BLACK);
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            AncPole.setDisable(true);
            lblWinLoss.setText("You Lost!");
            checkWin();
            //makes pole turn black when hit by jellyfish, loss method
        }
        if (collision(AncJellytwo, AncPole)) {
            RecFishpole.setFill(Color.BLACK);
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            lblWinLoss.setText("You Lost!");
            AncPole.setDisable(true);
            checkWin();
            //makes pole turn black when hit by jellyfish, loss method
        }
        if (collision(AncJellythr, AncPole)) {
        RecFishpole.setFill(Color.BLACK);
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            lblWinLoss.setText("You Lost!");
            AncPole.setDisable(true);
            checkWin();
            //makes pole turn black when hit by jellyfish, loss method
        }
        if (collision(AncJellyfour, AncPole)) {
         RecFishpole.setFill(Color.BLACK);
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            lblWinLoss.setText("You Lost!");
            AncPole.setDisable(true);
            checkWin();
        }
    }

    public boolean collision(AnchorPane block1, AnchorPane block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));

    }

    private void moveCamera() {

        AncCamfive.setTranslateX(AncCamfive.getTranslateX() + directionX);
        AncCamfive.setTranslateY(AncCamfive.getTranslateY() + directionY);
        AncCameig.setTranslateX(AncCameig.getTranslateX() + directionX);
        AncCameig.setTranslateY(AncCameig.getTranslateY() + directionY);
        AncCamsix.setTranslateX(AncCamsix.getTranslateX() + directionX);
        AncCamsix.setTranslateY(AncCamsix.getTranslateY() + directionY);
        AncCamsev.setTranslateX(AncCamsev.getTranslateX() + directionX);
        AncCamsev.setTranslateY(AncCamsev.getTranslateY() + directionY);

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
        if (collision(AncCamfive, recWallr)) {
              AncCamfive.setTranslateX(AncCamfive.getTranslateX() - directionX);
        AncCamfive.setTranslateY(AncCamfive.getTranslateY() - directionY);
        }
        if (collision(AncCamfive, AncPole)) {
                       AncCamfive.setTranslateX(AncCamfive.getTranslateX() - directionX);
        AncCamfive.setTranslateY(AncCamfive.getTranslateY() - directionY);  
        }

        if (collision(AncCamsix, recWallr)) {
                         AncCamsix.setTranslateX(AncCamsix.getTranslateX() - directionX);
        AncCamsix.setTranslateY(AncCamsix.getTranslateY() - directionY);  
        }
        if (collision(AncCamsix, recWalll)) {
                       AncCamsix.setTranslateX(AncCamsix.getTranslateX() - directionX);
        AncCamsix.setTranslateY(AncCamsix.getTranslateY() - directionY);  
        }
        if (collision(AncCamsev, recWallr)) {
                            AncCamsev.setTranslateX(AncCamsev.getTranslateX() - directionX);
        AncCamsev.setTranslateY(AncCamsev.getTranslateY() - directionY);  
        }
        if (collision(AncCamsev, recWalll)) {
                                    AncCamsev.setTranslateX(AncCamsev.getTranslateX() - directionX);
        AncCamsev.setTranslateY(AncCamsev.getTranslateY() - directionY);  
        }
        if (collision(AncCameig, recWallr)) {
                            AncCameig.setTranslateX(AncCameig.getTranslateX() - directionX);
        AncCameig.setTranslateY(AncCameig.getTranslateY() - directionY);  
        }
        if (collision(AncCameig, recWalll)) {
                             AncCameig.setTranslateX(AncCameig.getTranslateX() - directionX);
        AncCameig.setTranslateY(AncCameig.getTranslateY() - directionY);  
        }
    }

    public boolean collision(Rectangle block1, AnchorPane block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    private void moveFish() {

        AncFishten.setTranslateX(AncFishten.getTranslateX() + directionX);
        AncFishten.setTranslateY(AncFishten.getTranslateY() + directionY);
        AncFishnine.setTranslateX(AncFishnine.getTranslateX() + directionX);
        AncFishnine.setTranslateY(AncFishnine.getTranslateY() + directionY);
        AncFisheigh.setTranslateX(AncFisheigh.getTranslateX() + directionX);
        AncFisheigh.setTranslateY(AncFisheigh.getTranslateY() + directionY);
        AncFishsev.setTranslateX(AncFishsev.getTranslateX() + directionX);
        AncFishsev.setTranslateY(AncFishsev.getTranslateY() + directionY);
        AncFishSix.setTranslateX(AncFishSix.getTranslateX() + directionX);
        AncFishSix.setTranslateY(AncFishSix.getTranslateY() + directionY);
        AncFishFive.setTranslateX(AncFishFive.getTranslateX() + directionX);
        AncFishFive.setTranslateY(AncFishFive.getTranslateY() + directionY);
        AncFishfour.setTranslateX(AncFishfour.getTranslateX() + directionX);
        AncFishfour.setTranslateY(AncFishfour.getTranslateY() + directionY);
        AncFishthr.setTranslateX(AncFishthr.getTranslateX() + directionX);
        AncFishthr.setTranslateY(AncFishthr.getTranslateY() + directionY);
        AncFishtwo.setTranslateX(AncFishtwo.getTranslateX() + directionX);
        AncFishtwo.setTranslateY(AncFishtwo.getTranslateY() + directionY);
        AncFishone.setTranslateX(AncFishone.getTranslateX() + directionX);
        AncFishone.setTranslateY(AncFishone.getTranslateY() + directionY);

        if (collision(AncFishone, recWallr)) {
        AncFishone.setTranslateX(AncFishone.getTranslateX() - directionX);
        AncFishone.setTranslateY(AncFishone.getTranslateY() - directionY);  

        }
        if (collision(AncFishone, recWalll)) {
         AncFishone.setTranslateX(AncFishone.getTranslateX() - directionX);
        AncFishone.setTranslateY(AncFishone.getTranslateY() - directionY);  
     

        }
        if (collision(AncFishtwo, recWallr)) {
         AncFishtwo.setTranslateX(AncFishtwo.getTranslateX() - directionX);
        AncFishtwo.setTranslateY(AncFishtwo.getTranslateY() - directionY);  

        }
        if (collision(AncFishtwo, recWalll)) {
            AncFishtwo.setTranslateX(AncFishtwo.getTranslateX() - directionX);
        AncFishtwo.setTranslateY(AncFishtwo.getTranslateY() - directionY);  

        }
        if (collision(AncFishthr, recWallr)) {
            AncFishthr.setTranslateX(AncFishthr.getTranslateX() - directionX);
        AncFishthr.setTranslateY(AncFishthr.getTranslateY() - directionY);  

        }
        if (collision(AncFishthr, recWalll)) {
           AncFishthr.setTranslateX(AncFishthr.getTranslateX() - directionX);
        AncFishthr.setTranslateY(AncFishthr.getTranslateY() - directionY);  
        }
        if (collision(AncFishfour, recWallr)) {
    AncFishfour.setTranslateX(AncFishfour.getTranslateX() - directionX);
        AncFishfour.setTranslateY(AncFishfour.getTranslateY() - directionY);  

        }
        if (collision(AncFishfour, recWalll)) {
          AncFishfour.setTranslateX(AncFishfour.getTranslateX() - directionX);
        AncFishfour.setTranslateY(AncFishfour.getTranslateY() - directionY);  

        }
        if (collision(AncFishFive, recWallr)) {
            AncFishFive.setTranslateX(AncFishFive.getTranslateX() - directionX);
        AncFishFive.setTranslateY(AncFishFive.getTranslateY() - directionY);  


        }
        if (collision(AncFishFive, recWalll)) {
         AncFishFive.setTranslateX(AncFishFive.getTranslateX() - directionX);
        AncFishFive.setTranslateY(AncFishFive.getTranslateY() - directionY);  

        }
        if (collision(AncFishSix, recWallr)) {
           AncFishSix.setTranslateX(AncFishSix.getTranslateX() - directionX);
        AncFishSix.setTranslateY(AncFishSix.getTranslateY() - directionY);  

        }
        if (collision(AncFishSix, recWalll)) {
            AncFishSix.setTranslateX(AncFishSix.getTranslateX() - directionX);
        AncFishSix.setTranslateY(AncFishSix.getTranslateY() - directionY);  

        }
        if (collision(AncFishsev, recWallr)) {
            AncFishsev.setTranslateX(AncFishsev.getTranslateX() - directionX);
        AncFishsev.setTranslateY(AncFishsev.getTranslateY() - directionY);  

        }
        if (collision(AncFishsev, recWalll)) {
              AncFishsev.setTranslateX(AncFishsev.getTranslateX() - directionX);
        AncFishsev.setTranslateY(AncFishsev.getTranslateY() - directionY); 

        }
        if (collision(AncFisheigh, recWallr)) {
              AncFisheigh.setTranslateX(AncFisheigh.getTranslateX() - directionX);
        AncFisheigh.setTranslateY(AncFisheigh.getTranslateY() - directionY); 

        }
        if (collision(AncFisheigh, recWalll)) {
                AncFisheigh.setTranslateX(AncFisheigh.getTranslateX() - directionX);
        AncFisheigh.setTranslateY(AncFisheigh.getTranslateY() - directionY); 

        }
        if (collision(AncFishnine, recWallr)) {
           AncFishnine.setTranslateX(AncFishnine.getTranslateX() - directionX);
        AncFishnine.setTranslateY(AncFishnine.getTranslateY() - directionY); 
   }
        
        if (collision(AncFishnine, recWalll)) {
              AncFishnine.setTranslateX(AncFishnine.getTranslateX() - directionX);
        AncFishnine.setTranslateY(AncFishnine.getTranslateY() - directionY); 
        }
        
        if (collision(AncFishten, recWallr)) {
              AncFishten.setTranslateX(AncFishten.getTranslateX() - directionX);
        AncFishten.setTranslateY(AncFishten.getTranslateY() - directionY); 

        }
        if (collision(AncFishten, recWalll)) {
            AncFishten.setTranslateX(AncFishten.getTranslateX() - directionX);
        AncFishten.setTranslateY(AncFishten.getTranslateY() - directionY); 

        }
    }

    public boolean collision(AnchorPane block1, Rectangle block2) {
        return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }

    private void moveJellyfish() {

        AncJellyone.setTranslateX(AncJellyone.getTranslateX() + directionX);
        AncJellyone.setTranslateY(AncJellyone.getTranslateY() + directionY);
        AncJellytwo.setTranslateX(AncJellytwo.getTranslateX() + directionX);
        AncJellytwo.setTranslateY(AncJellytwo.getTranslateY() + directionY);
        AncJellythr.setTranslateX(AncJellythr.getTranslateX() + directionX);
        AncJellythr.setTranslateY(AncJellythr.getTranslateY() + directionY);
        AncJellyfour.setTranslateX(AncJellyfour.getTranslateX() + directionX);
        AncJellyfour.setTranslateY(AncJellyfour.getTranslateY() + directionY);

        if (collision(AncJellyone, recWallr)) {
         AncJellyone.setTranslateX(AncJellyone.getTranslateX() - directionX);
        AncJellyone.setTranslateY(AncJellyone.getTranslateY() - directionY); 
        }
        
        if (collision(AncJellyone, recWalll)) {
               AncJellyone.setTranslateX(AncJellyone.getTranslateX() - directionX);
        AncJellyone.setTranslateY(AncJellyone.getTranslateY() - directionY); 
        }
        
        if (collision(AncJellytwo, recWallr)) {
                AncJellytwo.setTranslateX(AncJellytwo.getTranslateX() - directionX);
        AncJellytwo.setTranslateY(AncJellytwo.getTranslateY() - directionY); 
        }
        
        if (collision(AncJellytwo, recWalll)) {
        AncJellytwo.setTranslateX(AncJellytwo.getTranslateX() - directionX);
        AncJellytwo.setTranslateY(AncJellytwo.getTranslateY() - directionY); 
        }
        
        if (collision(AncJellythr, recWallr)) {
  AncJellythr.setTranslateX(AncJellytwo.getTranslateX() - directionX);
        AncJellythr.setTranslateY(AncJellytwo.getTranslateY() - directionY); 
        }
        
        if (collision(AncJellythr, recWalll)) {
          AncJellythr.setTranslateX(AncJellytwo.getTranslateX() - directionX);
        AncJellythr.setTranslateY(AncJellytwo.getTranslateY() - directionY); 
        }
        
        if (collision(AncJellyfour, recWallr)) {
       AncJellyfour.setTranslateX(AncJellyfour.getTranslateX() - directionX);
        AncJellyfour.setTranslateY(AncJellyfour.getTranslateY() - directionY); 

        }
        if (collision(AncJellyfour, recWalll)) {
  AncJellyfour.setTranslateX(AncJellyfour.getTranslateX() - directionX);
        AncJellyfour.setTranslateY(AncJellyfour.getTranslateY() - directionY); 
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
            fishtime.stop();
            camerastime.stop();
            jellyfishtime.stop();
            int Winning;
        }
    }

    @FXML
    void btnPlay(ActionEvent event) {
        //starts timers when you press play
        AncPreStart.setVisible(false);
        AncPole.setDisable(false);
        directionX = -10;
        directionY = 0;
        run = true;
        score = 0;
        lblCooler.setText("" + score);
        camerastime.setCycleCount(Timeline.INDEFINITE);
        camerastime.play();
        fishtime.setCycleCount(Timeline.INDEFINITE);
        fishtime.play();
        jellyfishtime.setCycleCount(Timeline.INDEFINITE);
        jellyfishtime.play();
        btnTools.setDisable(false);
         RecFishpole.setFill(Color.RED);    
         
         
    }

    
    void Winning(String msg) {
        //Comfirmation message when loss or win occurs 
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Game Over");
        alert.setContentText("Game has ended, choose an option");
        ButtonType buttonTypeOne = new ButtonType("Play again");
        ButtonType buttonTypeTwo = new ButtonType("Exit game");
        ButtonType buttonTypeThree = new ButtonType("Three");
        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree);
        Optional<ButtonType> Result = alert.showAndWait();
        lblWinLoss.setText("You Won!");

        if (score == 10) {
            wins++;
            lblWins.setText("" + wins);
        }

        if (alert.getResult() == buttonTypeOne) {
            int btnRest;
        }

        if (alert.getResult() == buttonTypeTwo) {
            System.exit(0);
        }

    

        /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnTools.setDisable(true);
        btnExit.setVisible(false);
        btnRest.setVisible(false);
        AncPreStart.setVisible(true);
        AncPole.setDisable(true);
            AnchorPane temp[] = {AncFishone, AncFishtwo, AncFishthr, AncFishfour, AncFishFive,
            AncFishsev, AncFisheigh, AncFishnine, AncFishten};
        fish = temp;
          AnchorPane temp1[] = {AncJellyone, AncJellytwo, AncJellythr, AncJellyfour};
        jellyfish = temp1;
            AnchorPane temp2[] = {AncCamfive, AncCamsix, AncCamsev, AncCameig};
        cameras = temp2;
    }
}
// music didn't work out with youtube to mp3 conversion (activated the firewall)
