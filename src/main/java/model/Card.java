package model;

import enums.Rank;
import enums.Suit;

public class Card {

    public final Rank rank;

    public final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
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
}
