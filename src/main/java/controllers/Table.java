package controllers;

import Exceptions.EmptyDeckException;
import app.Kierki;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Table {

    private Hand firstHandController;

    private Hand secondHandController;

    public void init() throws IOException, EmptyDeckException {
        FXMLLoader firstHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        AnchorPane firstHand = firstHandLoader.load();
        model.Hand firstHandModel = new model.Hand(false);
        firstHandController = firstHandLoader.getController();
        firstHandController.initModel(firstHandModel);

        FXMLLoader secondHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        AnchorPane secondHand = secondHandLoader.load();
        model.Hand secondHandModel = new model.Hand(true);
        secondHandController = secondHandLoader.getController();
        secondHandController.initModel(secondHandModel);

        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/table.fxml"));
        AnchorPane table = tableLoader.load();
        table.getChildren().add(firstHand);
        table.getChildren().add(secondHand);
        secondHand.setLayoutY(450);
        Scene scene = Kierki.getScene();
        scene.setRoot(table);
        Kierki.getPrimaryStage().sizeToScene();
    }
}
