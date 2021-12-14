
package ryan.teamproject;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 Meghan Ryan
 12/13/2021
 Color Memorization Mini Game
 */

public class ColourMemo implements Initializable {
   
    ArrayList<Integer> pattern = new ArrayList();
    int patternNum;
    int squareNum;
    int patternSize;
    boolean correct;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> lightUp()));
    Image red = new Image(getClass().getResource("/red.jpg").toString());
    Image blue = new Image(getClass().getResource("/blue.png").toString());
    Image yellow = new Image(getClass().getResource("/yellow.jpg").toString());
    Image green = new Image(getClass().getResource("/green.png").toString());
    Image litRed = new Image(getClass().getResource("/redlit.png").toString());
    Image litBlue = new Image(getClass().getResource("/bluelit.png").toString());
    Image litYellow = new Image(getClass().getResource("/yellowlit.jpg").toString());
    Image litGreen = new Image(getClass().getResource("/greenlit.png").toString());
    
    @FXML
    private ImageView imgRed;
    @FXML
    private ImageView imgBlue;
    @FXML
    private ImageView imgGreen;
    @FXML
    private ImageView imgYellow;
    
    @FXML
    private Label lblStreak;
    
    @FXML
    private Button btnStart;
    
    void lightUp(){
        getPattern();
        if (patternNum==patternSize){
            patternNum=0;
            imgRed.setImage(red);
            imgBlue.setImage(blue);
            imgYellow.setImage(yellow);
            imgGreen.setImage(green);
            timeline.stop();          
        }
        else{
        switch(squareNum){
        case 1:
            imgRed.setImage(litRed);
            imgBlue.setImage(blue);
            imgYellow.setImage(yellow);
            imgGreen.setImage(green);
	break;
	case 2:
            imgRed.setImage(red);
            imgBlue.setImage(litBlue);
            imgYellow.setImage(yellow);
            imgGreen.setImage(green);
	break;
	case 3:
            imgRed.setImage(red);
            imgBlue.setImage(blue);
            imgYellow.setImage(litYellow);
            imgGreen.setImage(green);
	break;
	case 4:
            imgRed.setImage(red);
            imgBlue.setImage(blue);
            imgYellow.setImage(yellow);
            imgGreen.setImage(litGreen);
	break;
	default:
	break;
        }       
            patternNum=patternNum+1;
        }
    }
    
    void makePattern(){
        int rand = ThreadLocalRandom.current().nextInt(1,4+1);
            patternNum=0;
            pattern.add(rand);
            patternSize = pattern.size();
            lblStreak.setText(""+(patternSize));
            timeline.play();
    }
    
    void getPattern(){
        patternSize=pattern.size();
        if (patternNum!=patternSize){
        squareNum=pattern.get(patternNum);
        }
    }
    
    @FXML
    void imgSquare (MouseEvent event){
        ImageView imageView = (ImageView) event.getSource();
        imageView.setFitHeight(setHeight);
        imageView.setFitWidth(setWidth);
        imageView.setTranslateX(0);
        imageView.setTranslateY(0);
        imageView.toBack();
        if (imageView==imgRed){
            imgRed.setImage(red);           
        }
        else if (imageView==imgBlue){            
            imgBlue.setImage(blue);
        }
        else if (imageView==imgYellow){           
            imgYellow.setImage(yellow);
        }
        else if (imageView==imgGreen){
            imgGreen.setImage(green);
        }
        ImageView square=(ImageView) event.getSource();
        int squareClicked=Integer.parseInt(square.getAccessibleText());
        getPattern();
        correct=squareClicked==squareNum;
        if (correct==true){
            if (patternNum==patternSize){
                makePattern();
            }
            else {
                patternNum=patternNum+1;
            }
        }
        else {
            lose();
        }
    }
    
    void lose(){
        pattern.clear();
        patternNum=0;
        btnStart.setDisable(false);
    }
    
    @FXML
    void btnStartClick (ActionEvent event){
        makePattern();
        timeline.play();
        btnStart.setDisable(true);
    }
    
    @FXML
    void btnMenu(ActionEvent event) {
        System.exit(0);
    }
   
    double setHeight;
    double setWidth;
      
    /* Button expands when mouse hovers over, shrinks when mouse stops hovering over it. */
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
    
    /* Image expands when mouse hovers over, shrinks when mouse stops hovering over it. */
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
        if (imageView==imgRed){
            imgRed.setImage(litRed);           
        }
        else if (imageView==imgBlue){            
            imgBlue.setImage(litBlue);
        }
        else if (imageView==imgYellow){           
            imgYellow.setImage(litYellow);
        }
        else if (imageView==imgGreen){
            imgGreen.setImage(litGreen);
        }
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
        if (imageView==imgRed){
            imgRed.setImage(red);           
        }
        else if (imageView==imgBlue){            
            imgBlue.setImage(blue);
        }
        else if (imageView==imgYellow){           
            imgYellow.setImage(yellow);
        }
        else if (imageView==imgGreen){
            imgGreen.setImage(green);
        }
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline.setCycleCount(Timeline.INDEFINITE);
    }  
}
