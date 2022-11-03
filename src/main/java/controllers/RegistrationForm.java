package controllers;

import Exceptions.BadRequestException;
import app.Kierki;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class RegistrationForm {

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    public void onRegister(ActionEvent e) throws IOException {
        try {
            model.RegistrationForm.handleRegister(loginTextField.getText(), passwordTextField.getText());
            Scene scene = Kierki.getScene();
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/login-form.fxml"));
            AnchorPane loginForm = loginLoader.load();
            scene.setRoot(loginForm);
        } catch (BadRequestException ex) {
            throw new RuntimeException(ex);
        }

    }
}
