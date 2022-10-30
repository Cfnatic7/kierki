package controllers;

import javafx.fxml.FXML;
import org.w3c.dom.Text;

public class Card {

    @FXML
    private Text color;

    @FXML
    private Text value;

    public Text getColor() {
        return color;
    }

    public void setColor(Text color) {
        this.color = color;
    }

    public Text getValue() {
        return value;
    }

    public void setValue(Text value) {
        this.value = value;
    }

}
