package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Game;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private Game a_game;

    @FXML
    private Button PlayNewGame;

    @FXML
    private Button Hit;

    @FXML
    private Button Stand;

    @FXML
    private TextField DealerScore;

    @FXML
    private TextField PlayerScore;

    @FXML
    private ImageView Deck;

    @FXML
    private ImageView DealerCard1;

    @FXML
    private ImageView DealerCard2;

    @FXML
    private ImageView PlayerCard1;

    @FXML
    private ImageView PlayerCard2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image[] deckBack = {new Image("model/PNG/blue_back.png"), new Image("model/PNG/gray_back.png"), new Image("model/PNG/green_back.png"),
                new Image("model/PNG/purple_back.png"), new Image("model/PNG/red_back.png"), new Image("model/PNG/yellow_back.png")};

        this.Deck.setImage(deckBack[0]);
    }

    @FXML
    void PlayGame(ActionEvent event) throws IOException {
        //        Parent playGameView = FXMLLoader.load(getClass().getResource("../view/PlayNewGame.fxml"));
//
//        Scene playScene = new Scene(playGameView);
//        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
//        window.setScene(playScene);
//        window.show();

        a_game.NewGame();



    }

    @FXML
    public
    @FXML
    void Deck() throws IOException {

    }


}
