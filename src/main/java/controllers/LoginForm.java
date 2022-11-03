package controllers;

import Exceptions.BadRequestException;
import app.Kierki;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginForm {

    @FXML
    private TextField loginTextField;

    @FXML
    private TextField passwordTextField;

    private model.LoginForm loginFormModel;

    public void initModel() {
        loginFormModel = new model.LoginForm();
    }

    public void onLogin(ActionEvent e) throws IOException {
        try {
            loginFormModel.handleLogin(loginTextField.getText(), passwordTextField.getText());
            Scene scene = Kierki.getScene();
            FXMLLoader roomLoader = new FXMLLoader(getClass().getResource("/rooms.fxml"));
            scene.setRoot(roomLoader.load());
        } catch (BadRequestException ex) {
            throw new RuntimeException(ex);
        }

    }

    public TextField getLoginTextField() {
        return loginTextField;
    }

    public TextField getPasswordTextField() {
        return passwordTextField;
    }

    public model.LoginForm getLoginFormModel() {
        return loginFormModel;
    }
}
