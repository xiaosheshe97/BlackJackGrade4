package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button playGameButton;

    @FXML
    void PlayGame(ActionEvent event) throws IOException {
        Parent playGameView = FXMLLoader.load(getClass().getResource("../view/PlayNewGame.fxml"));

        Scene playScene = new Scene(playGameView);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(playScene);
        window.show();
    }

}
