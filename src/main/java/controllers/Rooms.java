package controllers;

import Exceptions.EmptyDeckException;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Rooms {

    public void onChooseRoom() throws IOException, EmptyDeckException {
        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/table.fxml"));
        tableLoader.load();
        Table tableController = tableLoader.getController();
        tableController.init();
    }

}
