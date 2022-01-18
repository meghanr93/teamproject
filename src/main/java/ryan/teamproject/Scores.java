package ryan.teamproject;
/*
Meghan Ryan
01/05/2022
Player Scores Page
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
import javafx.scene.control.ListView;

public class Scores implements Initializable{

    @FXML
    private Label lblColourMemoScore;
    @FXML
    private Label lblFishingScore;
    @FXML
    private Label lblFroggerScore;
    @FXML
    private ListView lstScores;

    @FXML
    void btnMenu(ActionEvent event)throws IOException {
        MainApp.setRoot("primary");
    }

    // Button expands when mouse hovers over, shrinks when mouse stops hovering over it.
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
        
    }
}