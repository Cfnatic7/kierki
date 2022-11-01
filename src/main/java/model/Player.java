package model;

public class Player {

    private boolean isEnemy;

    private boolean firstTurn;

    private Card cardPlayed;

    private boolean turn;

    private Player oppositePlayer;

    public Player(boolean isEnemy, boolean turn, boolean firstTurn) {
        this.isEnemy = isEnemy;
        this.turn = turn;
        this.firstTurn = firstTurn;
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

    public Player getOppositePlayer() {
        return oppositePlayer;
    }

    public void setOppositePlayer(Player oppositePlayer) {
        this.oppositePlayer = oppositePlayer;
    }

    public boolean isFirstTurn() {
        return firstTurn;
    }

    public void setFirstTurn(boolean firstTurn) {
        this.firstTurn = firstTurn;
    }


}
