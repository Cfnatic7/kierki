package content;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Hand {

    private ObservableList<Node> cards;

    private SimpleIntegerProperty value = new SimpleIntegerProperty(0);

    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }
}
