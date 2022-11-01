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

    private model.Table tableModel;

    private Hand firstHandController;

    private Hand secondHandController;

    public void init() throws IOException, EmptyDeckException {
        tableModel = new model.Table();
        AnchorPane firstHand = getFirstHand();

        AnchorPane secondHand = getSecondHand();

        configurePlayers();

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
        AnchorPane secondHand = secondHandLoader.load();
        Player ourPlayerModel = new Player(false, true, true);

        model.Hand secondHandModel = new model.Hand(ourPlayerModel, this.tableModel);
        tableModel.setOurPlayerModel(secondHandModel);
        secondHandController = secondHandLoader.getController();
        secondHandController.initModel(secondHandModel);
        return secondHand;
    }

    private AnchorPane getFirstHand() throws IOException, EmptyDeckException {
        FXMLLoader firstHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        AnchorPane firstHand = firstHandLoader.load();
        Player enemyPlayerModel = new Player(true, false, false);
        model.Hand firstHandModel = new model.Hand(enemyPlayerModel, this.tableModel);
        tableModel.setOurPlayerModel(firstHandModel);
        firstHandController = firstHandLoader.getController();
        firstHandController.initModel(firstHandModel);
        return firstHand;
    }

    private void configurePlayers() {
        firstHandController.getHandModel().getPlayer().setOppositePlayer(secondHandController.getHandModel().getPlayer());
        secondHandController.getHandModel().getPlayer().setOppositePlayer(firstHandController.getHandModel().getPlayer());
    }

    private void initializeTextNodes() {
        enemyPlayerPoints.setText("Points: 0");
        ourPlayerPoints.setText("Points: 0");
    }
}
