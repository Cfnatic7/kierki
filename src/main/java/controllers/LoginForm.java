package controllers;

import app.Kierki;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.Objects;

public class LoginForm {

    private model.LoginForm loginFormModel;

    public void initModel() {
        loginFormModel = new model.LoginForm();
    }

    public void onLogin(ActionEvent e) throws IOException {
        Scene scene = Kierki.getScene();
        FXMLLoader roomLoader = new FXMLLoader(getClass().getResource("/rooms.fxml"));
        scene.setRoot(roomLoader.load());
    }

}
