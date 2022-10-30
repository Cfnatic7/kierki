package controllers;

import app.Kierki;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Objects;

public class InitialView {

    public void loginOnClick(ActionEvent e) throws IOException {
        Scene scene = Kierki.getScene();
        Parent loginForm = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/login-form.fxml")));
        scene.setRoot(loginForm);
    }

    public void registerOnClick(ActionEvent e) throws IOException {
        Scene scene = Kierki.getScene();
        Parent registerForm = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/registration-form.fxml")));
        scene.setRoot(registerForm);
    }
}
