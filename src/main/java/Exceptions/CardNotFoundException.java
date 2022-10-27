package Exceptions;

public class CardNotFoundException extends Exception {
    public CardNotFoundException() {
        super("Card not found");
    }
}
