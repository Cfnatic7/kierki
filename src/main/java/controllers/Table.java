package controllers;

import app.Kierki;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class Table {

    @FXML
    private AnchorPane table;

    @FXML
    private Text enemyPlayerPoints;

    @FXML
    private Text ourPlayerPoints;

    private Hand ourHandController;

    private Hand enemyHardController;

    public void init() throws IOException {
        AnchorPane enemyHand = getEnemyHand();

        AnchorPane ourHand = getOurHand();



        initializeTextNodes();
        table.getChildren().add(enemyHand);
        table.getChildren().add(ourHand);
        ourHand.setLayoutY(450);
        Scene scene = Kierki.getScene();
        scene.setRoot(table);
        Kierki.getPrimaryStage().sizeToScene();
        Kierki.setEnemyPlayerPoints(enemyPlayerPoints);
        Kierki.setOurPlayerPoints(ourPlayerPoints);
    }

    private AnchorPane getOurHand() throws IOException {
        FXMLLoader ourHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        AnchorPane ourHandView = ourHandLoader.load();
        ourHandController = ourHandLoader.getController();
        Kierki.setOurHandPane(ourHandView);
        return ourHandView;
    }

    private AnchorPane getEnemyHand() throws IOException {
        FXMLLoader enemyHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        AnchorPane enemyHandView = enemyHandLoader.load();
        Kierki.setEnemyHandPane(enemyHandView);
        return enemyHandView;
    }

    private void initializeTextNodes() {
        enemyPlayerPoints.setText("Points: 0");
        ourPlayerPoints.setText("Points: 0");
    }
}
