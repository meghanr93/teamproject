package ryan.teamproject;
/*
Meghan Ryan
01/05/2022
Player Scores Page
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    ArrayList<player> players=new ArrayList();//
    int playercount;

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
    
    void readPlayers(){
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
    
    void listUpdate() {
        //Updates the listBox 
        lstScores.getItems().clear();  //clears the list each time so it can be reset from the arrayList
        for (int i = 0; i < players.size(); i++) {
            lstScores.getItems().add("Name: " + players.get(i).getName());
        }
    }
    
    @FXML
    void lstClick(MouseEvent event) {
        try{
            int selectedIndex = lstScores.getSelectionModel().getSelectedIndex();
            lblColourMemoScore.setText("" + players.get(selectedIndex).getMemoScore());
            lblFroggerScore.setText("" + players.get(selectedIndex).getFroggerScore());
            lblFishingScore.setText("" + players.get(selectedIndex).getFishingScore());
        }
        catch(Exception ex){          
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readPlayers();
        listUpdate();
    }
}