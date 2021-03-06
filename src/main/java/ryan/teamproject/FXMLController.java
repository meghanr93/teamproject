package ryan.teamproject;
/*
Meghan Ryan
12/15/2021
Starting title screen to access different parts of the program.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    //Opens the game menu screen.
    void btnGames(ActionEvent event)throws IOException {
        MainApp.setRoot("gamesMenu");
    }

    //Info button to explain the program.
    @FXML
    void btnInfo(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Info");
        alert.setHeaderText(null);
        alert.setContentText("Open the game menu to access 3 different mini games.");
        alert.showAndWait();
    }

    @FXML
    void btnScores(ActionEvent event)throws IOException {
        MainApp.setRoot("scores");
    }
    
    @FXML
    //Exits the program.
    void btnExit(ActionEvent event) {
        System.exit(0);
    }
    
    double setHeight;
    double setWidth;
    
    //Button expands when mouse hovers over, shrinks when mouse stops hovering over it.
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
    
    }    
}
