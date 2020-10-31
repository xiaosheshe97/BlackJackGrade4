package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Card;
import model.Dealer;
import model.Game;
import model.ICardObserver;
import model.rules.BasicHitAmericanGameDealerWinFactory;
import model.rules.IVisitor;
import model.rules.RulesAbstractFactory;
import view.PrintVisitor;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, ICardObserver{
    private RulesAbstractFactory factory;
    private IVisitor iVisitor;
    private Game a_game;

    private Image[] deckBack = {new Image("model/PNG/blue_back.png"), new Image("model/PNG/gray_back.png"), new Image("model/PNG/green_back.png"),
            new Image("model/PNG/purple_back.png"), new Image("model/PNG/red_back.png"), new Image("model/PNG/yellow_back.png")};

    private String cardType;

    private Image card;

    @Override
    public void updateNewCard(Card card) {
        String cardScores[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
        card.Show(true);
        this.cardType = cardScores[card.GetValue().ordinal()] + card.GetColor().toString().charAt(0);
        System.out.println(this.cardType);
        this.card = new Image("model/PNG/" + this.cardType + ".png");
        Pause();
    }

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.factory = new BasicHitAmericanGameDealerWinFactory();
        this.iVisitor = new PrintVisitor();
        this.a_game = new Game(factory, iVisitor);
        this.a_game.SubscriptionToNewCards(this);
        DeckBack();
    }

    @FXML
    void PlayNewGame() {
        this.a_game.NewGame();
        PlayerCard1.setImage(this.card);
        DeckBack();
        DealerCard1.setImage(this.card);
        DeckBack();
        PlayerCard2.setImage(new Image("model/PNG/" + this.cardType + ".png"));
        DeckBack();
        DealerCard2.setImage(new Image("model/PNG/" + this.cardType + ".png"));

        PlayerScore.setText(String.valueOf(a_game.GetPlayerScore()));
        DealerScore.setText(String.valueOf(a_game.GetDealerScore()));
    }

    @FXML
    void Hit(ActionEvent event) throws IOException {
        this.Deck.setImage(deckBack[(int)(Math.random() * 6)]);

    }

    @FXML
    void Stand(ActionEvent event) throws IOException {
        this.Deck.setImage(deckBack[(int)(Math.random() * 6)]);

    }

    public void Pause(){
        try{
            System.out.println("getting ....");
            Thread.sleep(2000);
        }catch (Exception e){}
    }

    private void DeckBack() {
        this.Deck.setImage(deckBack[(int)(Math.random() * 6)]);
    }
}
