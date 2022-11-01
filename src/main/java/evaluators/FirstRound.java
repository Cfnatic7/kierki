package evaluators;

import model.Hand;
import model.Player;

public class FirstRound {

//    public static final int FIRST_ROUND_POINTS = -20;
//
//    public static boolean isMoveValid(Player one, Player two) {
//        if (one.getCardPlayed() == null || two.getCardPlayed() == null) return false;
//        if (one.isFirstTurn()) {
//            return validatePlayerTwo(one, two);
//        }
//        else {
//            return validatePlayerOne(one, two);
//        }
//    }
//
//    private static boolean validatePlayerOne(Player one, Player two) {
//        if (two.getCardPlayed().suit == one.getCardPlayed().suit) return true;
//        boolean hasColor = false;
//        for (var card : one.getHand().getCards()) {
//            if (card.get().suit == one.getCardPlayed().suit) {
//                hasColor = true;
//                break;
//            }
//        }
//        if (hasColor && two.getCardPlayed().suit != one.getCardPlayed().suit) return false;
//        else return !hasColor && two.getCardPlayed().suit != one.getCardPlayed().suit;
//    }
//
//    private static boolean validatePlayerTwo(Player one, Player two) {
//        if (two.getCardPlayed().suit == one.getCardPlayed().suit) return true;
//        boolean hasColor = false;
//        for (var card : two.getHand().getCards()) {
//            if (card.get().suit == one.getCardPlayed().suit) {
//                hasColor = true;
//                break;
//            }
//        }
//        if (hasColor && two.getCardPlayed().suit != one.getCardPlayed().suit) return false;
//        else return !hasColor && two.getCardPlayed().suit != one.getCardPlayed().suit;
//    }
//
//    public void evaluateMove(Player one, Player two) {
//        if (one.isFirstTurn()) {
//            if (two.getCardPlayed().suit != one.getCardPlayed().suit) {
//                one.setFirstTurn(true);
//                two.setFirstTurn(false);
//                one.setTurn(true);
//                two.setTurn(false);
//                one.setPoints(one.getPoints() + FIRST_ROUND_POINTS);
//            }
//            else {
//                if (one.getCardPlayed().rank.value > two.getCardPlayed().rank.value) {
//                    one.setFirstTurn(true);
//                    two.setFirstTurn(false);
//                    one.setTurn(true);
//                    two.setTurn(false);
//                    one.setPoints(one.getPoints() + FIRST_ROUND_POINTS);
//                }
//                else {
//                    one.setFirstTurn(true);
//                    two.setFirstTurn(false);
//                    one.setTurn(true);
//                    two.setTurn(false);
//                    one.setPoints(one.getPoints() + FIRST_ROUND_POINTS);
//                }
//            }
//        }
//    }
//
//    private void handleEvaluateMoveResult(boolean firstPlayerWin, Player one, Player two) {
//        one.setFirstTurn(firstPlayerWin);
//        two.setFirstTurn(!firstPlayerWin);
//        one.setTurn(firstPlayerWin);
//        two.setTurn(!firstPlayerWin);
//        if (firstPlayerWin) {
//            one.setPoints(one.getPoints() + FIRST_ROUND_POINTS);
//        } else {
//            two.setPoints(two.getPoints() + FIRST_ROUND_POINTS);
//        }
//        one.setPoints(one.getPoints() + FIRST_ROUND_POINTS);
//    }
}
