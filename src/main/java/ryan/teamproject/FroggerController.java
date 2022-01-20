/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ryan.teamproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *Charley Treen
 * January 17th, 2021
 * Frogger like game with Keypress and an ability to win and lose
 */
public class FroggerController implements Initializable {

  AnchorPane temp1[
                ] = {AncCarone, AncCartwo, AncCarthr, AncCarfour, AncCarfive, AncCarsix, AncCarseven, AncCareig, AncCarnine, AncCarten, AncCarelev };
        cars = temp1;  
        
          AnchorPane temp1[
                ] = {AncLogone, AncLogtwo, AncLogthr, AncLogfour};
        logs = temp2;
        
        Timeline cartimer = new Timeline(new KeyFrame(Duration.millis(50), ae -> movecars()));
        Timeline logtimer = new Timeline(new KeyFrame(Duration.millis(50), ae -> movelogs()));

timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();

timeline.setCycleCount(Timeline.INDEFINITE);
timeline.play();



@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
