package model;

import Exceptions.CardNotFoundException;
import Exceptions.EmptyDeckException;
import Exceptions.InternalServerErrorException;
import app.Kierki;
import enums.Commands;
import enums.Rank;
import enums.ServerResponses;
import enums.Suit;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class Hand {

    private final ObservableList<SimpleObjectProperty<Card>> cards;

    private final static int HALF_THE_DECK = 26;


    public Hand() {
        cards = FXCollections.observableArrayList();
    }

    public void drawCardsFromDeck() throws EmptyDeckException {
        for (int i = 0; i < HALF_THE_DECK; i++) {
            Card card = Deck.drawCard();
            card.setHandModel(this);
            cards.add(new SimpleObjectProperty<>(card));
        }
        if (Deck.getCards().isEmpty()) Deck.refill();
    }

    public Card playCard(Card card) throws CardNotFoundException {
        int index = cards.indexOf(card);
        if (index == -1) throw new CardNotFoundException();
        cards.remove(index);
        return card;
    }

    public void requestCards() throws IOException {
        Kierki.dataOut.writeUTF(Commands.GET_HAND.name());
        Kierki.dataIn.readUTF();
        for (int i = 0; i < Deck.HALF_THE_DECK; i++) {
            Suit suit = Suit.valueOf(Kierki.dataIn.readUTF());
            Rank rank = Rank.valueOf(Kierki.dataIn.readUTF());
            cards.add(new SimpleObjectProperty<>(new Card(rank, suit)));
        }
        Kierki.dataIn.readUTF();
    }

    public void reset() {
        cards.clear();
    }

    public ObservableList<SimpleObjectProperty<Card>> getCards() {
        return this.cards;
    }
}
