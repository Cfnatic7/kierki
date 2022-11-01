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

    private double initialYLayout;

    private SimpleObjectProperty<model.Card> cardModel = null;

    public void initModel(SimpleObjectProperty<model.Card> cardModel) {
//        if (cardModel != null) {
//            throw new IllegalStateException("Model can only be initialized once");
//        }
        this.cardModel = cardModel;
        this.setColor(this.cardModel.get().suit.toString());
        this.setValue(this.cardModel.get().rank.toString());
    }

    public void onHover() {
        cardPane.toFront();
    }

    public void onClick() {
        AnchorPane handPane = (AnchorPane) this.cardPane.getParent();
        var cards = handPane.getChildren();
        cards.forEach(card -> card.setLayoutY(initialYLayout));
        if (this.cardModel.get().isOpponent) {
            this.cardPane.setLayoutY(this.cardPane.getLayoutY() + 50);
        }
        else {
            this.cardPane.setLayoutY(this.cardPane.getLayoutY() - 50);
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
