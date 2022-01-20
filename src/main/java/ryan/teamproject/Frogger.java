/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ryan.teamproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author meghanr93
 */
public class Frogger implements Initializable{
    
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
