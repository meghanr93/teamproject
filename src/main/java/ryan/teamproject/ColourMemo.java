
package ryan.teamproject;
/*
 Meghan Ryan
 12/13/2021
 Color Memorization Mini Game
 */

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class ColourMemo implements Initializable {
    
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
   
    ArrayList<Integer> pattern = new ArrayList();
    int patternNum;
    int squareNum;
    int patternSize;
    boolean correct;
    boolean canClick=false;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), ae -> lightUp()));
    Image red = new Image(getClass().getResource("/red.png").toString());
    Image blue = new Image(getClass().getResource("/blue.png").toString());
    Image yellow = new Image(getClass().getResource("/yellow.png").toString());
    Image green = new Image(getClass().getResource("/green.png").toString());
    Image litRed = new Image(getClass().getResource("/redlit.png").toString());
    Image litBlue = new Image(getClass().getResource("/bluelit.png").toString());
    Image litYellow = new Image(getClass().getResource("/yellowlit.png").toString());
    Image litGreen = new Image(getClass().getResource("/greenlit.png").toString());
    MediaPlayer soundPlayer;
    ArrayList<player> players=new ArrayList();
    
    //Code to change the coloured square images.
    void setColours(Image red, Image blue, Image yellow, Image green){
        imgRed.setImage(red);
        imgBlue.setImage(blue);
        imgYellow.setImage(yellow);
        imgGreen.setImage(green);
    }
    
    //Code lighting up the coloured squares to show the pattern.
    void lightUp(){
        getPattern();
        if (patternNum==patternSize){
            patternNum=0;
            setColours(red,blue,yellow,green);
            timeline.stop();   
            canClick=true;
        }
        else{
        switch(squareNum){
        case 1:
            setColours(litRed,blue,yellow,green);
	break;
	case 2:
            setColours(red,litBlue,yellow,green);
	break;
	case 3:
            setColours(red,blue,litYellow,green);
	break;
	case 4:
            setColours(red,blue,yellow,litGreen);
	break;
	default:
	break;
        }       
            patternNum=patternNum+1;
        }
    }
    
    void normalSize(ImageView imageView){
        imageView.setFitHeight(150);
        imageView.setFitWidth(150);
        imageView.setTranslateX(0);
        imageView.setTranslateY(0);
        imageView.toBack();
    }
    
    //Makes an addition to the colour pattern.
    void makePattern(){
        int rand = ThreadLocalRandom.current().nextInt(1,4+1);
            patternNum=0;
            pattern.add(rand);
            patternSize = pattern.size();
            lblStreak.setText(""+(patternSize-1));
            timeline.play();
    }
    
    //Gets the colour pattern.
    void getPattern(){
        patternSize=pattern.size();
        if (patternNum!=patternSize){
        squareNum=pattern.get(patternNum);
        }
    }
    
    @FXML
    //Code plays when player clicks a square, testing if they are correctly following the pattern.
    void imgSquare (MouseEvent event){
        if (canClick==true){
        ImageView square = (ImageView) event.getSource();
        square.setFitHeight(setHeight);
        square.setFitWidth(setWidth);
        square.setTranslateX(0);
        square.setTranslateY(0);
        square.toBack();
        if (square==imgRed){
            imgRed.setImage(red);           
        }
        else if (square==imgBlue){            
            imgBlue.setImage(blue);
        }
        else if (square==imgYellow){           
            imgYellow.setImage(yellow);
        }
        else if (square==imgGreen){
            imgGreen.setImage(green);
        }
        int squareClicked=Integer.parseInt(square.getAccessibleText());
        getPattern();
        correct=squareClicked==squareNum;
        if (correct==true){
            playSound("/correct.mp3");
            if (patternNum==patternSize-1){
                makePattern();
                canClick=false;
            }
            else {
                patternNum=patternNum+1;
            }
        }
        else {
            lose();
        }
        }
    }
    
    //Code plays when an incorrect part of the pattern is chosen.
    void lose(){
        playSound("/incorrect.mp3");
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Scores");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter your name:");
        Optional<String> result = dialog.showAndWait();
        String name=dialog.getEditor().getText();
        readPlayers();
        if (players.contains(name)){
            if ((patternSize-1)>(players.get(a).getMemoScore())){
                players.get(a).setMemoScore(patternSize-1);
            }
            else{
                
            }
        }
        else{
            players.add(new player(name,(patternSize-1),0,0));
        }
        writePlayers();
        pattern.clear();
        patternNum=0;
        btnStart.setDisable(false);
        lblStreak.setText("0");
        canClick=false;
    }
    
    void readPlayers(){
        
    }
    
    void writePlayers(){
        
    }
    
    @FXML
    //Creates the first part of the colour pattern and starts the game.
    void btnStartClick (ActionEvent event){
        makePattern();
        timeline.play();
        btnStart.setDisable(true);
    }
    
    @FXML
    //Opens the game menu screen
    void btnMenu(ActionEvent event)throws IOException {
        MainApp.setRoot("gamesMenu");
    }
    
    //Plays a sound
    void playSound(String soundname){    
        soundPlayer = new MediaPlayer((new Media(getClass().getResource(soundname).toString())));
        soundPlayer.play();
    }
   
    double setHeight;
    double setWidth;
      
    /* Button expands when mouse hovers over, shrinks when mouse stops hovering over it. */
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
    
    /* Image expands when mouse hovers over, shrinks when mouse stops hovering over it. */
    @FXML
    void imgHover(MouseEvent event) {
        /* Causes Buttons to expand when hovered over. */
        if (canClick==true){
        normalSize(imgRed);
        normalSize(imgBlue);
        normalSize(imgYellow);
        normalSize(imgGreen);
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
    }   
    @FXML
    void imgUnhover(MouseEvent event) {
        /* Causes expanded Buttons to shrink back to original size when not hovered over. */
        if (canClick==true){
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
        normalSize(imgRed);
        normalSize(imgBlue);
        normalSize(imgYellow);
        normalSize(imgGreen);
    }
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        timeline.setCycleCount(Timeline.INDEFINITE);
    }  
}
