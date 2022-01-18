
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
   boolean run=false;
   int directionY=0;
    int directionX=0;
       int getTranslateY=0;
    int getTranslateX=0;
          int setTranslateY=0;
    int setTranslateX=0;
     Timeline camerastime = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveCamera()));
         Timeline fishtime = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveFish()));
             Timeline jellyfishtime = new Timeline(new KeyFrame(Duration.millis(50), ae -> moveJellyfish()));
     @FXML
    private AnchorPane AncFishone, AncFishtwo, AncFishthr, AncFishfour, AncFishFive, AncFishten, AncFishnine, AncFishsev, AncFisheigh, AncFishSix,
AncJellyfour, AncJellyone, AncJellytwo,AncJellythr, AncCamfive, AncCamthr, AncCamtwo, AncCamfou, AncCamone, AncCameig, AncCamsev, AncCamsix, AncPole, AncPreStart;
   
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
        btnTools.setDisable (false);
btnExit.setVisible (false);
btnRest.setVisible (false);
camerastime.setCycleCount(Timeline.INDEFINITE);
camerastime.stop();
fishtime.setCycleCount(Timeline.INDEFINITE);
fishtime.stop();
jellyfishtime.setCycleCount(Timeline.INDEFINITE);
jellyfishtime.stop();
        
        AnchorPane temp[] = {AncFishone, AncFishtwo, AncFishthr, AncFishfour, AncFishFive,
            AncFishsev, AncFisheigh, AncFishnine, AncFishten};
        fish = temp;

        /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
        
        for (AnchorPane name : fish) {
            name.setDisable(true);
        }
        AnchorPane temp1[] = {AncJellyone, AncJellytwo, AncJellythr, AncJellyfour};
        jellyfish = temp1;

        /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
        
        for (AnchorPane name : jellyfish) {
            name.setDisable(true);
        }
        AnchorPane temp2[] = {AncCamfive, AncCamsix, AncCamsev, AncCameig};
        cameras = temp2;

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
 wins=0;
    }

    @FXML
    void AncPole(KeyEvent event) throws IOException {
             AncPole.setTranslateX(AncPole.getTranslateX() + directionX);
        AncPole.setTranslateY(AncPole.getTranslateY() + directionY); 
        Rectangle rec = (Rectangle) event.getSource();
        
                if (event.getCode() == KeyCode.D) {
            directionX=10;
            directionY=0;
        }
    
    
            if (event.getCode() == KeyCode.X) {
            directionX=0;
            directionY=-10;
        }
    
                if (event.getCode() == KeyCode.A) {
            directionX=-10;
            directionY=0;
        }
        
                if (event.getCode() == KeyCode.W) {
            directionX=0;
            directionY=10;
        }
                if (collision(recWallpr, AncPole))  {
               directionX=1;
           directionY=0; 
                }
                  if (collision(recWallpl, AncPole))  {
               directionX=1;
           directionY=0; 
                }
                
        if (collision(recWallt, AncPole))  {
         directionX=0;
            directionY=1;   
        }
        
          if (collision(recWallb, AncPole))  {
         directionX=0;
            directionY=1;   
        }
          
     if (collision(AncFishone, AncPole))  {
            ArcFishnin.setVisible(true);
             AncFishone.setVisible(true);
//makes fish disappear in water and "reappear" on ice
               score++;
                lblCooler.setText("" + score);
                 checkWin();
        }
        if (collision(AncFishtwo, AncPole))  {
            ArcFishtwen.setVisible(true);
            AncFishtwo.setVisible(false);
              score++;
              lblCooler.setText("" + score);
                       checkWin();
                       //makes fish disappear in water and "reappear" on ice
        }
         if (collision(AncFishthr, AncPole))  {
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
         if (collision(AncFishFive, AncPole))  {
            ArcFishtwe.setVisible(true);
            AncFishFive.setVisible(false);
              score++;
              lblCooler.setText("" + score);
                       checkWin();
                       //makes fish disappear in water and "reappear" on ice
        }
         if (collision(AncFishSix, AncPole))  {
            ArcFishsixt.setVisible(true);
            AncFishSix.setVisible(false);
              score++;
              lblCooler.setText("" + score);
                       checkWin();
                       //makes fish disappear in water and "reappear" on ice
        }
        if (collision(AncFishsev, AncPole))  {
            ArcFishseve.setVisible(true);
            AncFishsev.setVisible(false);
              score++;
              lblCooler.setText("" + score);
                       checkWin();
                       //makes fish disappear in water and "reappear" on ice
        }
         if (collision(AncFisheigh, AncPole))  {
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
         if (collision(AncFishten, AncPole))  {
            ArcFishthi.setVisible(true);
            AncFishten.setVisible(false);
              score++;
              lblCooler.setText("" + score);
                       checkWin();
                       //makes fish disappear in water and "reappear" on ice
        }

         if (collision(AncJellyone, AncPole))  {
            rec.setFill(Color.BLACK);
           fishtime.stop();
           camerastime.stop();
           jellyfishtime.stop();
            lblWinLoss.setText ("You Lost!");
        AncPole.setDisable(true);
        checkWin();
        //makes pole turn black when hit by jellyfish, loss method
        }
        if (collision(AncJellytwo, AncPole))  {
            rec.setFill(Color.BLACK);
           fishtime.stop();
           camerastime.stop();
           jellyfishtime.stop();
            lblWinLoss.setText ("You Lost!");
                   AncPole.setDisable(true);
                 checkWin();
                       //makes pole turn black when hit by jellyfish, loss method
        }
       if (collision(AncJellythr, AncPole))  {
            rec.setFill(Color.BLACK);
           fishtime.stop();
           camerastime.stop();
           jellyfishtime.stop();
            lblWinLoss.setText ("You Lost!");
                   AncPole.setDisable(true);
                checkWin();
                       //makes pole turn black when hit by jellyfish, loss method
        }
        if (collision(AncJellyfour, AncPole)) {
            rec.setFill(Color.BLACK);
           fishtime.stop();
           camerastime.stop();
           jellyfishtime.stop();
            lblWinLoss.setText ("You Lost!");
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
        
        if (collision(AncCamsix, AncPole))  {
            AncCamtwo.setVisible(true);
             AncCamsix.setVisible(false);
//makes camera disappear in water and "reappear" on ice
        }
         if (collision(AncCamsev, AncPole))  {
            AncCamthr.setVisible(true);
             AncCamsev.setVisible(false);
             
//makes camera disappear in water and "reappear" on ice
        }
           if (collision(AncCameig, AncPole))  {
            AncCamfou.setVisible(true);
             AncCameig.setVisible(false);
//makes camera disappear in water and "reappear" on ice

        } if (collision(AncCamfive, recWallr)) {
            directionX=-10;
            directionY=0;
        }
               if (collision(AncCamfive, AncPole)) {
            directionX=10;
            directionY=0;  
        }
              
                     if (collision(AncCamsix, recWallr)) {
            directionX=-10;
            directionY=0;   
        }
              if (collision(AncCamsix, recWalll)) {
            directionX=10;
            directionY=0;  
        }
                     if (collision(AncCamsev, recWallr)) {
            directionX=-10;
            directionY=0;    
        }
              if (collision(AncCamsev, recWalll)) {
            directionX=10;
            directionY=0;  
        }
            if (collision(AncCameig, recWallr)) {
            directionX=-10;
            directionY=0; 
        }
              if (collision(AncCameig, recWalll)) {
            directionX=10;
            directionY=0;  
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
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishone, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFishtwo, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishtwo, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFishthr, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishthr, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFishfour, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishfour, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFishFive, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishFive, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFishSix, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishSix, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFishsev, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishsev, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFisheigh, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFisheigh, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFishnine, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishnine, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                     if (collision(AncFishten, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
              if (collision(AncFishten, recWalll)) {
            directionX=10;
            directionY=0;
            
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
            directionX=-10;
            directionY=0;
            
        }
             if (collision(AncJellyone, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                    if (collision(AncJellytwo, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
             if (collision(AncJellytwo, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                    if (collision(AncJellythr, recWallr)) {
            directionX=-10;
            directionY=0;
            
        }
             if (collision(AncJellythr, recWalll)) {
            directionX=10;
            directionY=0;
            
        }
                    if (collision(AncJellyfour, recWallr)) {
            directionX=-5;
            directionY=0;
            
        }
             if (collision(AncJellyfour, recWalll)) {
            directionX=10;
            directionY=0;
            
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
    public void keyPressed(KeyEvent event)  {
        if (event.getCode() == KeyCode.D) {
      
        }
    
            if (event.getCode() == KeyCode.X) {
     
        }
       
                if (event.getCode() == KeyCode.A) {
        
        }
       
                if (event.getCode() == KeyCode.W) {
  
        }
        }
   
    @FXML
    void btnPlay(ActionEvent event) {
       //starts timers when you press play
        AncPreStart.setVisible(false);
        AncPole.setDisable(false);
            directionX=-10;
            directionY=0;
            run=true;
           score=0;
             lblCooler.setText("" + score);
      
camerastime.setCycleCount(Timeline.INDEFINITE);
camerastime.play();
fishtime.setCycleCount(Timeline.INDEFINITE);
fishtime.play();
jellyfishtime.setCycleCount(Timeline.INDEFINITE);
jellyfishtime.play();
btnTools.setDisable (false);
 
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
    lblWinLoss.setText ("You Won!");
           
    if (score==10) {wins++;
     lblWins.setText("" + wins);
    }
    
        if (alert.getResult() == buttonTypeOne) {
            int btnRest;
            }
            
            if (alert.getResult() == buttonTypeTwo) {
            System.exit(0); 
        }
    
        AnchorPane temp[] = {AncFishone, AncFishtwo, AncFishthr, AncFishfour, AncFishFive,
            AncFishsev, AncFisheigh, AncFishnine, AncFishten};
        fish = temp;

        /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
        for (AnchorPane name : fish) {
            name.setDisable(true);
        }
        AnchorPane temp1[
                ] = {AncJellyone, AncJellytwo, AncJellythr, AncJellyfour};
        jellyfish = temp1;

        /* creates an array of all the fish listed, makes them all 
      identified as "fish" */
        for (AnchorPane name : jellyfish) {
            name.setDisable(true);
        }
        AnchorPane temp2[] = {AncCamfive, AncCamsix, AncCamsev, AncCameig};
        cameras = temp2;

        /* creates an array of all the cameras listed, makes them all 
      identified as "cameras" */
        for (AnchorPane name : cameras) {
            name.setDisable(true);
            //disables timer for cameras movement
        }
    }

   @Override
     public void initialize(URL url, ResourceBundle rb) {
btnTools.setDisable (true);
btnExit.setVisible (false);
btnRest.setVisible (false);
AncPreStart.setVisible(true);
AncPole.setDisable(true);
     }     
    }
// music didn't work out with youtube to mp3 conversion (activated the firewall)
