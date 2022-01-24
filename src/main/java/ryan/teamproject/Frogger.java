/*
Meghan Ryan
1/20/2022
Game with a frog character where you have to press keys to avoid obstacles.
*/
package ryan.teamproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.TextInputDialog;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author meghanr93
 */
public class Frogger implements Initializable{
    
    @FXML
    private ImageView imgFrog;
    @FXML
    private Label lblInvisBox;
    @FXML
    private Label lblScore;
    @FXML
    private Button btnStart;
    @FXML
    private Label lblSeaweed1;
    @FXML
    private Label lblSeaweed2;
    @FXML
    private Label lblSeaweed3;
    @FXML
    private Label lblSeaweed4;
    
    ArrayList<player> players=new ArrayList();//
    int playercount;
    
    MediaPlayer soundPlayer;
    
    //Plays a sound
    void playSound(String soundname){    
        soundPlayer = new MediaPlayer((new Media(getClass().getResource(soundname).toString())));
        soundPlayer.play();
    }
    
    boolean started=false;
    int score=0;
    int rand;
    double seaweedSpeed=5;
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), ae -> moveSeaweed()));
    
    void moveSeaweed(){
        if (rand!=1){
            lblSeaweed1.setTranslateY((lblSeaweed1.getTranslateY())+seaweedSpeed);
        }
        if (rand!=2){
            lblSeaweed2.setTranslateY((lblSeaweed2.getTranslateY())+seaweedSpeed);
        }
        if (rand!=3){
            lblSeaweed3.setTranslateY((lblSeaweed3.getTranslateY())+seaweedSpeed);
        }
        if (rand!=4){
            lblSeaweed4.setTranslateY((lblSeaweed4.getTranslateY())+seaweedSpeed);
        }
        if (collisionTwo(lblSeaweed1,lblInvisBox)==true){
            collisionTwoCode();
        }
        else if (collisionTwo(lblSeaweed2,lblInvisBox)==true){
            collisionTwoCode();
        }
        if (collision(imgFrog,lblSeaweed1)==true){
           lose(); 
        }
        else if (collision(imgFrog,lblSeaweed2)==true){
           lose(); 
        }
        else if (collision(imgFrog,lblSeaweed3)==true){
           lose(); 
        }
        else if (collision(imgFrog,lblSeaweed4)==true){
           lose(); 
        }
    }
    
    void lose(){
        lblSeaweed1.setTranslateY(0);
        lblSeaweed2.setTranslateY(0);
        lblSeaweed3.setTranslateY(0);
        lblSeaweed4.setTranslateY(0);
        seaweedSpeed=5;
        /*score
        TextInputDialog dialog = new TextInputDialog("");
        dialog.setTitle("Scores");
        dialog.setHeaderText(null);
        dialog.setContentText("Please enter your name:");
        Optional<String> result = dialog.showAndWait();
        String name=dialog.getEditor().getText();
        readPlayers();
        */
        score=0;
        lblScore.setText(""+score);
        timeline.stop();
        started=false;
        btnStart.setDisable(false);
        playSound("/sad_trombone.mp3");
    }   
    
    void collisionTwoCode(){
        lblSeaweed1.setTranslateY(0);
        lblSeaweed2.setTranslateY(0);
        lblSeaweed3.setTranslateY(0);
        lblSeaweed4.setTranslateY(0);
        rand = ThreadLocalRandom.current().nextInt(1,4+1);
        score=score+1;
        lblScore.setText(""+score);
        if (seaweedSpeed!=20){
        seaweedSpeed=seaweedSpeed+0.5;
        }
        playSound("/coin.mp3");
    }
    
    /*void readPlayers(){
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("playercount.txt"));
            playercount = Integer.parseInt(readFile.readLine());
            readFile.close();
        } catch (IOException e) {
        }
        players.clear();
        try {
            BufferedReader readFile = new BufferedReader(new FileReader("scores.txt"));           
            for (int i = 0; i < playercount; i++) {
                players.add(new player(readFile.readLine(),Integer.parseInt(readFile.readLine()),Integer.parseInt(readFile.readLine()),Integer.parseInt(readFile.readLine())));
            }
            readFile.close();
        } catch (IOException e) {
        }
    }
    
    void writePlayers(){
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter("playercount.txt"))) {
            outFile.write(""+playercount);
        } catch (IOException e) {
        }
        try (BufferedWriter outFile = new BufferedWriter(new FileWriter("scores.txt"))) {
            for (int i = 0; i < playercount; i++) {
                outFile.write(players.get(i).getName());
                outFile.newLine();
                outFile.write(""+players.get(i).getMemoScore());
                outFile.newLine();
                outFile.write(""+players.get(i).getFishingScore());
                outFile.newLine();
                outFile.write(""+players.get(i).getFroggerScore());
                outFile.newLine();
            }
        } catch (IOException e) {
        }
    }*/
    
    @FXML
    void btnMenu(ActionEvent event)throws IOException {
        MainApp.setRoot("primary");
    }
    
    public void keyPressed(KeyEvent event){
        if ((started==true)&&(event.getCode() == KeyCode.Q)) {
            imgFrog.setLayoutX(106);
        }
        else if ((started==true)&&(event.getCode() == KeyCode.W)) {
            imgFrog.setLayoutX(216);
        }
        else if ((started==true)&&(event.getCode() == KeyCode.E)) {
            imgFrog.setLayoutX(326);
        }
        else if ((started==true)&&(event.getCode() == KeyCode.R)) {
            imgFrog.setLayoutX(436);
        }
    }
    
    public boolean collision(ImageView block1, Label block2) {
    //returns true if the areas intersect, false if they dont
    return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }
    
    public boolean collisionTwo(Label block1, Label block2) {
    //returns true if the areas intersect, false if they dont
    return (block1.getBoundsInParent().intersects(block2.getBoundsInParent()));
    }
    
    @FXML
    void btnStartClick(ActionEvent event) {
        started=true;
        btnStart.setDisable(true);
        rand = ThreadLocalRandom.current().nextInt(1,4+1);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
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
