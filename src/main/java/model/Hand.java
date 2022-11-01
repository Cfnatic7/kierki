package model;

import Exceptions.CardNotFoundException;
import Exceptions.EmptyDeckException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Hand {

    private final ObservableList<SimpleObjectProperty<Card>> cards;

    private final static int HALF_THE_DECK = 26;

    private final Player player;

    private final Table tableModel;

    public Hand(Player player, Table tableModel) {
        cards = FXCollections.observableArrayList();
        this.player = player;
        this.tableModel = tableModel;
    }

    public void drawCardsFromDeck() throws EmptyDeckException {
        for (int i = 0; i < HALF_THE_DECK; i++) {
            Card card = Deck.drawCard();
            card.setIsOpponent(this.player.isEnemy());
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

    public void reset() {
        cards.clear();
    }

    public ObservableList<SimpleObjectProperty<Card>> getCards() {
        return this.cards;
    }

    public Player getPlayer() {
        return this.player;
    }
}
