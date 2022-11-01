package model;

public class Player {

    private boolean isEnemy;

    private Card cardPlayed;

    private boolean turn;

    public Player(boolean isEnemy, boolean turn) {
        this.isEnemy = isEnemy;
        this.turn = turn;
    }

    public Card getCardPlayed() {
        return cardPlayed;
    }

    public void setCardPlayed(Card cardPlayed) {
        this.cardPlayed = cardPlayed;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    public void setEnemy(boolean enemy) {
        isEnemy = enemy;
    }

}
