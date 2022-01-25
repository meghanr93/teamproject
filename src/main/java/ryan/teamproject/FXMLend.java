/*Charley Treen
End screen for aracade, includes exit or buttons to replay each game, total score 
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import static ryan.teamproject.MainApp.setRoot;

/**
 * FXML Controller class
 *Charley Treen
 * January 17th, 2021
 * End screen
 */
//please ignore frogger, now changed to end screen
public class FXMLend implements Initializable {

  @FXML
    private Button btnMemory;

    @FXML
    private Button btnFrogger;

    @FXML
    private Button btnFish;

    @FXML
    private Button btnExitProgram;

    @FXML
    private Label lblScore;

    @FXML
    void btnExitProgram(ActionEvent event) {
System.exit(0);
//exit program with zero errors
    }

    @FXML
    void btnFish(ActionEvent event) throws IOException {
    MainApp.setRoot("ice");
    }

    @FXML
    void btnFrogger(ActionEvent event) throws IOException {
    MainApp.setRoot("frogger");
    }

    @FXML
    void btnMemory(ActionEvent event) throws IOException {
    MainApp.setRoot("colourMemo");
    }
    
    @FXML
    void btnGameMenuClick(ActionEvent event) throws IOException {
    MainApp.setRoot("gamesMenu");
    }
    
    //Button expands when mouse hovers over, shrinks when mouse stops hovering over it.
    double setHeight;
    double setWidth;
    @FXML
    void btnHover(MouseEvent event) {
        Button button = (Button) event.getSource();
        setHeight=button.getPrefHeight();
        setWidth=button.getPrefWidth();
        button.setPrefHeight(setHeight*1.1);
        button.setPrefWidth(setWidth*1.1);
        button.setTranslateX((setWidth-setWidth*1.1)/2);
        button.setTranslateY((setHeight-setHeight*1.1)/2);
        button.toFront();     
    }   
    @FXML
    void btnUnhover(MouseEvent event) {
        Button button = (Button) event.getSource();
        button.setPrefHeight(setHeight);
        button.setPrefWidth(setWidth);
        button.setTranslateX(0);
        button.setTranslateY(0);
        button.toBack();
    }


@Override
    public void initialize(URL url, ResourceBundle rb) {
        lblScore.setText(""+MainApp.gameScore);
    }    
    
}
