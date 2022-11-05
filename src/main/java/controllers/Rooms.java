package controllers;

import Exceptions.BadRequestException;
import Exceptions.EmptyDeckException;
import Exceptions.InternalServerErrorException;
import app.Kierki;
import enums.RoomNumber;
import javafx.event.ActionEvent;
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

    private Background defaultButtonBg;

    private final BackgroundFill background_fill = new BackgroundFill(Color.GRAY,
            CornerRadii.EMPTY, Insets.EMPTY);

    private final Background unactiveButtonBg = new Background(background_fill);

    @FXML
    public void initialize() {
        defaultButtonBg = firstRoom.getBackground();
    }

    public void onChooseRoom(ActionEvent e) throws IOException, EmptyDeckException {
        var target = e.getTarget();
        if (!(target instanceof Button)) return;
        RoomNumber roomNumber = getRoomNumber((Button) target);
        System.out.println("button text: " + ((Button) target).getText());
        try {
            model.Rooms.handleRoomJoin(roomNumber);
        } catch(BadRequestException ex) {
            System.out.println("Can't join room");
            return;
        }

        FXMLLoader tableLoader = new FXMLLoader(getClass().getResource("/table.fxml"));
        AnchorPane table = tableLoader.load();
        Table tableController = tableLoader.getController();
        tableController.init();
        Kierki.getScene().setRoot(table);
    }

    private RoomNumber getRoomNumber(Button target) {
        RoomNumber roomNumber = null;
        Button button = target;
        if (button.getText().equals("pokój 1")) {
            roomNumber = RoomNumber.ONE;
        }
        else if (button.getText().equals("pokój 2")) {
            roomNumber = RoomNumber.TWO;
        }
        else if (button.getText().equals("pokój 3")) {
            roomNumber = RoomNumber.THREE;
        }
        else if (button.getText().equals("pokój 4")) {
            roomNumber = RoomNumber.FOUR;
        }
        return roomNumber;
    }

}
