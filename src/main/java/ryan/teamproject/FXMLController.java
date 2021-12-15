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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FXMLController implements Initializable {

    @FXML
    //Opens the game menu screen.
    void btnGames(ActionEvent event)throws IOException {
        MainApp.setRoot("gamesMenu");
    }

    @FXML
    void btnInfo(ActionEvent event) {

    }

    @FXML
    void btnScores(ActionEvent event) {

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
        // TODO
    }    
}
