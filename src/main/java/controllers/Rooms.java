package controllers;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class Rooms {

    public void onChooseRoom() throws IOException {
        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/table.fxml"));
        tableLoader.load();
        Table tableController = tableLoader.getController();
        tableController.init();
    }

}
