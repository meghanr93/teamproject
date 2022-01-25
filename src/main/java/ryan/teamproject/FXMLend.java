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
import static ryan.teamproject.MainApp.setRoot;

/**
 * FXML Controller class
 *Charley Treen
 * January 17th, 2021
 * Frogger like game with Keypress and an ability to win and lose
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
MainApp.setRoot("primary");

    }

    @FXML
    void btnFrogger(ActionEvent event) {
/*@FXML
private void btnClickAction(ActionEvent event) throws IOException {
MainApp.setRoot("page2");
}*/
    }

    @FXML
    void btnMemory(ActionEvent event) {
/*@FXML
private void btnClickAction(ActionEvent event) throws IOException {
MainApp.setRoot("page2");
}*/
    }


@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
