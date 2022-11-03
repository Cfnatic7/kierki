package controllers;

import Exceptions.BadRequestException;
import app.Kierki;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class RegistrationForm {

    private model.RegistrationForm registrationFormModel;

    public void initModel() {
        registrationFormModel = new model.RegistrationForm();
    }

    public void onRegister(ActionEvent e) throws IOException {
        try {
            registrationFormModel.handleRegister(loginTextField.getText(), passwordTextField.getText());
            Scene scene = Kierki.getScene();
            FXMLLoader roomLoader = new FXMLLoader(getClass().getResource("/login.fxml"));
            scene.setRoot(roomLoader.load());
        } catch (BadRequestException ex) {
            throw new RuntimeException(ex);
        }

    }
}
