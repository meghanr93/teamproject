package ryan.teamproject;
/*
Meghan Ryan
12/15/2021    
This screen is a menu to access the mini games.
*/

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Games {
       
    //Opens the mini game screens.
    @FXML
    void imgColourMemo(MouseEvent event)throws IOException {
        MainApp.setRoot("colourMemo");
    }
    @FXML
    void imgFishing(MouseEvent event)throws IOException {

    }
    @FXML
    void imgFrogger(MouseEvent event)throws IOException {
        MainApp.setRoot("Frogger");
    }

        
    @FXML
    //Opens the title screen.
    void btnMenu(ActionEvent event)throws IOException {
        MainApp.setRoot("primary");
    }
    
    //Brings up an Alert box.
    void gameInfo(String info){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Info");
        alert.setHeaderText(null);
        alert.setContentText(info);
        alert.showAndWait();
    }

    //Game information buttons.
    @FXML
    void btnColourMemoInfo(ActionEvent event) {
        gameInfo("A colour memorization game. The coloured squares will flash in a pattern that you must memorize. Repeat the pattern correctly and the pattern will get longer by one. See how long of a pattern you can memorize!");
    }
    @FXML
    void btnFishingInfo(ActionEvent event) {
        gameInfo("A fishing game. Catch fish and bring them back up to you while avoiding hazards.");
    }
    @FXML
    void btnFroggerInfo(ActionEvent event) {
        gameInfo("Press the Q, W, E, or R button to move the frog to a corresponding spot while avoiding getting tangled in the incoming seaweed. Go as far as you can!");
    }
    
    //Expand buttons/images when mouse hovers over, minimizes when the mouse stops hovering over it.
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
