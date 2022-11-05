package model;

import app.Kierki;
import enums.Commands;
import enums.Rank;
import enums.Suit;

import java.io.IOException;

public class Card {

    public final Rank rank;

    public final Suit suit;

    public Boolean isOpponent;

    private Hand handModel;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public void setHandModel(Hand handModel) {
        this.handModel = handModel;
    }

    @Override
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }

    @Override
    public boolean equals(Object card) {
        if (!(card instanceof Card)) return false;
        return ((Card) card).rank.value == this.rank.value && ((Card) card).suit == this.suit;
    }

    public void sendCardToServer() throws IOException {
        Kierki.dataOut.writeUTF(Commands.PLAY_CARD.name());
        Kierki.dataIn.readUTF();
        Kierki.dataOut.writeUTF(this.suit.name());
        Kierki.dataOut.writeUTF(this.rank.name());
        Kierki.dataIn.readUTF();
    }

    public void setIsOpponent(boolean isOpponent) {
        this.isOpponent = isOpponent;
    }

    public Boolean getIsOpponent() {
        return this.isOpponent;
    }

    public Hand getHandModel() {
        return this.handModel;
    }
}
