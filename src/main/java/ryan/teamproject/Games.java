/*
Meghan Ryan
12/15/2021    
This screen is a menu to access the mini games.
*/
package ryan.teamproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Games {
       
    @FXML
    //Opens the Colour Memorization mini game screen.
    void imgColourMemo(MouseEvent event)throws IOException {
        MainApp.setRoot("colourMemo");
    }
        
    @FXML
    //Opens the title screen.
    void btnMenu(ActionEvent event)throws IOException {
        MainApp.setRoot("primary");
    }
    
    @FXML
    void btnColourMemoInfo(ActionEvent event) {
        
    }
    
    double setHeight;
    double setWidth;
    
    @FXML
    void btnHover(MouseEvent event) {
        /* Causes Buttons to expand when hovered over. */
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
        /* Causes expanded Buttons to shrink back to original size when not hovered over. */
        Button button = (Button) event.getSource();
        button.setPrefHeight(setHeight);
        button.setPrefWidth(setWidth);
        button.setTranslateX(0);
        button.setTranslateY(0);
        button.toBack();
    }
    
    @FXML
    void imgHover(MouseEvent event) {
        /* Causes Buttons to expand when hovered over. */
        ImageView imageView = (ImageView) event.getSource();
        setHeight=imageView.getFitHeight();
        setWidth=imageView.getFitWidth();
        imageView.setFitHeight(setHeight*1.1);
        imageView.setFitWidth(setWidth*1.1);
        imageView.setTranslateX((setWidth-setWidth*1.1)/2);
        imageView.setTranslateY((setHeight-setHeight*1.1)/2);
        imageView.toFront();   
    }   
    @FXML
    void imgUnhover(MouseEvent event) {
        /* Causes expanded Buttons to shrink back to original size when not hovered over. */
        ImageView imageView = (ImageView) event.getSource();
        imageView.setFitHeight(setHeight);
        imageView.setFitWidth(setWidth);
        imageView.setTranslateX(0);
        imageView.setTranslateY(0);
        imageView.toBack();
        }
    
}
