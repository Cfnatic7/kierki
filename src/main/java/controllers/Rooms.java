package controllers;

import Exceptions.EmptyDeckException;
import app.Kierki;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Rooms {

    @FXML
    public Button firstRoom;

    @FXML
    public Button secondRoom;

    @FXML
    public Button thirdRoom;

    @FXML
    public Button fourthRoom;

    private final Background defaultButtonBg = firstRoom.getBackground();

    private final BackgroundFill background_fill = new BackgroundFill(Color.GRAY,
            CornerRadii.EMPTY, Insets.EMPTY);

    private final Background unactiveButtonBg = new Background(background_fill);

    private void startListening() {
        model.Rooms.getIsFirstRoomFree().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue) {
                firstRoom.setBackground(unactiveButtonBg);
            }
            else {
                firstRoom.setBackground(defaultButtonBg);
            }
        });

        model.Rooms.getIsSecondRoomFree().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue) {
                firstRoom.setBackground(unactiveButtonBg);
            }
            else {
                firstRoom.setBackground(defaultButtonBg);
            }
        });

        model.Rooms.getIsThirdRoomFree().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue) {
                firstRoom.setBackground(unactiveButtonBg);
            }
            else {
                firstRoom.setBackground(defaultButtonBg);
            }
        });

        model.Rooms.getIsFourthRoomFree().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue) {
                firstRoom.setBackground(unactiveButtonBg);
            }
            else {
                firstRoom.setBackground(defaultButtonBg);
            }
        });
    }

    @FXML
    public void initialize() {
        startListening();
    }

    public void onChooseRoom() throws IOException, EmptyDeckException {
        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/table.fxml"));
        AnchorPane table = tableLoader.load();
        Table tableController = tableLoader.getController();
        tableController.init();
        Kierki.getScene().setRoot(table);
    }

}
