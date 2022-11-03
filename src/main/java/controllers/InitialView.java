package controllers;

import app.Kierki;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class InitialView {

    public void loginOnClick(ActionEvent e) throws IOException {
        Scene scene = Kierki.getScene();
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/login-form.fxml"));
        AnchorPane loginForm = loginLoader.load();
        LoginForm loginFormController = loginLoader.getController();
        loginFormController.initModel();
        scene.setRoot(loginForm);
    }

    public void registerOnClick(ActionEvent e) throws IOException {
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("/register-form.fxml"));
        Parent registerLoad = registerLoader.load();
        LoginForm loginFormController = registerLoader.getController();
        Scene scene = Kierki.getScene();
        Parent registerForm = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/registration-form.fxml")));
        scene.setRoot(registerForm);
    }
}
