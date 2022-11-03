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
        FXMLLoader registerLoader = new FXMLLoader(getClass().getResource("/registration-form.fxml"));
        Parent registerForm = registerLoader.load();
        RegistrationForm registerFormController = registerLoader.getController();
        registerFormController.initModel();
        Scene scene = Kierki.getScene();
        scene.setRoot(registerForm);
    }
}
