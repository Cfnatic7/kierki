package controllers;

import app.Kierki;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class Card {

    @FXML
    private AnchorPane cardPane;
    @FXML
    private Text color;

    @FXML
    private Text value;

    private double initialYLayout;

    private model.Card cardModel = null;

    public void initModel(model.Card cardModel) {
//        if (cardModel != null) {
//            throw new IllegalStateException("Model can only be initialized once");
//        }
        this.cardModel = cardModel;
        this.setColor(this.cardModel.suit.toString());
        this.setValue(this.cardModel.rank.toString());
    }

    public void onHover() {
        cardPane.toFront();
    }

    public void onClick() {
        try {
            System.out.println("Tryind to send card");
            Kierki.setOurCardPane(this.cardPane);
            System.out.println("Clicked card: " + Kierki.getOurCardPane());
            this.cardModel.sendCardToServer();
        } catch (IOException e) {
            System.out.println("Card couldn't be send");
        }
    }

    public Text getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color.textProperty().setValue(color);
    }

    public Text getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value.textProperty().setValue(value);
    }

    public void setInitialYLayout(double initialYLayout) {
        this.initialYLayout = initialYLayout;
    }
}
