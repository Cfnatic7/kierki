package controllers;

import Exceptions.EmptyDeckException;
import app.Kierki;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Rooms {

    public void onChooseRoom() throws IOException, EmptyDeckException {
        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/table.fxml"));
        AnchorPane table = tableLoader.load();
        Table tableController = tableLoader.getController();
        tableController.init();
        tableController.initializeTextNodes();
        Kierki.getScene().setRoot(table);
    }

}
