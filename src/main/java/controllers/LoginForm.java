package controllers;

import app.Kierki;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class LoginForm {

    public void onLogin(ActionEvent e) throws IOException {
        Scene scene = Kierki.getScene();
        Parent rooms = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/rooms.fxml")));
        scene.setRoot(rooms);
    }

}
