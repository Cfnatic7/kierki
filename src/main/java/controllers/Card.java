package controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Card {

    @FXML
    private AnchorPane cardPane;
    @FXML
    private Text color;

    @FXML
    private Text value;

    private SimpleObjectProperty<model.Card> cardModel = null;

    public void initModel(SimpleObjectProperty<model.Card> cardModel) {
//        if (cardModel != null) {
//            throw new IllegalStateException("Model can only be initialized once");
//        }
        this.cardModel = cardModel;
        this.setColor(this.cardModel.get().suit.toString());
        this.setValue(this.cardModel.get().rank.toString());
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

}
