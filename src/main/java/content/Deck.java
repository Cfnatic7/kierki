package content;

import Exceptions.CardNotFoundException;
import Exceptions.EmptyDeckException;
import enums.Rank;
import enums.Suit;

import java.util.*;

public class Deck {

    private final List<Card> cards = new ArrayList<>(52);

    public Deck() {
        refill();
    }



    public final void refill() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() throws EmptyDeckException {
        if (cards.size() == 0) throw new EmptyDeckException();
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public Card useCard(Rank rank, Suit suit) throws CardNotFoundException {
        int index = cards.indexOf(new Card(rank, suit));
        if (index == -1) throw new CardNotFoundException();
        Card card = cards.get(index);
        cards.remove(index);
        return card;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
