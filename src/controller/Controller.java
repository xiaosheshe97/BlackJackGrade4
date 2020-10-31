package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

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

    @FXML
    void PlayGame(ActionEvent event) throws IOException {
        Parent playGameView = FXMLLoader.load(getClass().getResource("../view/PlayNewGame.fxml"));

        Scene playScene = new Scene(playGameView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(playScene);
        window.show();
    }

}
