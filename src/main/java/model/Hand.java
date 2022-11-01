package model;

import Exceptions.CardNotFoundException;
import Exceptions.EmptyDeckException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Hand {

    private final ObservableList<SimpleObjectProperty<Card>> cards;

    private final static int HALF_THE_DECK = 26;

    public Hand() throws EmptyDeckException {
        cards = FXCollections.observableArrayList();
    }

    public void drawCardsFromDeck() throws EmptyDeckException {
        for (int i = 0; i < HALF_THE_DECK; i++) {
            cards.add(new SimpleObjectProperty<>(Deck.drawCard()));
        }
        if (Deck.getCards().isEmpty()) Deck.refill();
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

    public ObservableList<SimpleObjectProperty<Card>> getCards() {
        return this.cards;
    }
}
