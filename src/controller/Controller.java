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
import model.Card;
import model.Game;
import model.ICardObserver;
import view.IView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller{
    private Game a_game;

    private Image[] deckBack = {new Image("model/PNG/blue_back.png"), new Image("model/PNG/gray_back.png"), new Image("model/PNG/green_back.png"),
            new Image("model/PNG/purple_back.png"), new Image("model/PNG/red_back.png"), new Image("model/PNG/yellow_back.png")};

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
    private ImageView DealerCard3;

    @FXML
    private ImageView DealerCard4;

    @FXML
    private ImageView DealerCard5;

    @FXML
    private ImageView DealerCard6;

    @FXML
    private ImageView PlayerCard1;

    @FXML
    private ImageView PlayerCard2;

    @FXML
    private ImageView PlayerCard3;

    @FXML
    private ImageView PlayerCard4;

    @FXML
    private ImageView PlayerCard5;

    @FXML
    private ImageView PlayerCard6;


//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        this.Deck.setImage(deckBack[0]);
//        this.DealerCard1.setImage(null);
//    }

    @FXML
    void PlayNewGame(ActionEvent event) throws IOException {
//        this.a_game.NewGame();
        this.Deck.setImage(deckBack[0]);

        Card card = new Card(Card.Color.Clubs, Card.Value.Two);
        card.Show(true);
        String cardType = card.GetValue() + "of" + card.GetColor();
        System.out.println(cardType);
//        DealerCard1.setImage(new Image("model/PNG/TwoofClubs.png"));

        DealerCard1.setImage(new Image("model/PNG/" + cardType + ".png"));
    }

    @FXML
    void Hit(ActionEvent event) throws IOException {
        this.a_game.Hit();

    }

    @FXML
    void Stand(ActionEvent event) throws IOException {
        this.a_game.Stand();

    }

}
