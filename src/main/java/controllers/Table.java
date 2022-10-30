package controllers;

import app.Kierki;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Table {

    private Hand firstHandController;

    private Hand secondHandController;

    public void init() throws IOException {
        FXMLLoader firstHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        firstHandController = firstHandLoader.getController();
        AnchorPane firstHand = firstHandLoader.load();

        FXMLLoader secondHandLoader = new FXMLLoader(getClass().getResource("/hand.fxml"));
        AnchorPane secondHand = secondHandLoader.load();
        secondHandController = secondHandLoader.getController();

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
