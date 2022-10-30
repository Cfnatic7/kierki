package model;

import Exceptions.CardNotFoundException;
import javafx.collections.ObservableList;
import javafx.scene.Node;

public class Hand {

    private ObservableList<Node> cards;

    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    public Hand() {
        // initialize cards
    }

    public Card playCard(Card card) throws CardNotFoundException {
        int index = cards.indexOf(card);
        if (index == -1) throw new CardNotFoundException();
        cards.remove(index);
        return card;
    }

    public void reset() {
        cards.clear();
    }
}
