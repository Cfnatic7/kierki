package controllers;

import Exceptions.EmptyDeckException;
import app.Kierki;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Player;

import java.io.IOException;

public class Table {

    @FXML
    private AnchorPane table;

    @FXML
    private Text enemyPlayerPoints;

    @FXML
    private Text ourPlayerPoints;

    public void init() throws IOException, EmptyDeckException {
        AnchorPane firstHand = getFirstHand();

        AnchorPane secondHand = getSecondHand();

        initializeTextNodes();
        table.getChildren().add(firstHand);
        table.getChildren().add(secondHand);
        secondHand.setLayoutY(450);
        Scene scene = Kierki.getScene();
        scene.setRoot(table);
        Kierki.getPrimaryStage().sizeToScene();
    }

    private AnchorPane getSecondHand() throws IOException, EmptyDeckException {
        FXMLLoader secondHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        return secondHandLoader.load();
    }

    private AnchorPane getFirstHand() throws IOException, EmptyDeckException {
        FXMLLoader firstHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        return firstHandLoader.load();
    }

    private void initializeTextNodes() {
        enemyPlayerPoints.setText("Points: 0");
        ourPlayerPoints.setText("Points: 0");
    }
}
