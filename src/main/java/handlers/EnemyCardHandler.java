package handlers;

import app.Kierki;
import controllers.Card;
import enums.Commands;
import enums.Rank;
import enums.ServerResponses;
import enums.Suit;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class EnemyCardHandler extends Thread {

    private boolean isRunning = true;

    private Socket receiveEnemyCardSocket;

    private DataInputStream receiveEnemyCardDataIn;

    public EnemyCardHandler(Socket receiveEnemyCardSocket) throws IOException {
        this.receiveEnemyCardSocket = receiveEnemyCardSocket;
        receiveEnemyCardDataIn = new DataInputStream(receiveEnemyCardSocket.getInputStream());
    }

    @Override
    public void run() {
        while(isRunning) {
            try {
                ServerResponses serverResponse = ServerResponses.valueOf(receiveEnemyCardDataIn.readUTF());
                if (serverResponse == ServerResponses.SEND_ENEMY_CARD) {
                    Suit suit = Suit.valueOf(receiveEnemyCardDataIn.readUTF());
                    Rank rank = Rank.valueOf(receiveEnemyCardDataIn.readUTF());
                    System.out.println("Card received");
                    Platform.runLater(() -> {
                        try {
                            addCardToEnemyHandView(suit, rank);
                        } catch(Exception e) {
                            System.out.println("Couldn't render card");
                        }
                    });
                }
                else if (serverResponse == ServerResponses.PLAY_CARD_ACK) {
                    AnchorPane cardPane = Kierki.getOurCardPane();
                    AnchorPane handPane = (AnchorPane) cardPane.getParent();
                    var cards = handPane.getChildren();
                    double initialYLayout = cardPane.getLayoutY();
                    cards.forEach(card -> card.setLayoutY(initialYLayout));
                    cardPane.setLayoutY(cardPane.getLayoutY() - 50);
                }
                else if (serverResponse == ServerResponses.POINTS) {
                    int points = Integer.parseInt(Kierki.getOurPlayerPoints().getText().split(" ")[1]);
                    points += Integer.parseInt(receiveEnemyCardDataIn.readUTF());
                    String newText = "Points: " + points;
                    Platform.runLater(() -> {
                        Kierki.getOurPlayerPoints().setText(newText);
                    });

                }
                else if (serverResponse == ServerResponses.ENEMY_POINTS) {
                    int points = Integer.parseInt(Kierki.getEnemyPlayerPoints().getText().split(" ")[1]);
                    points += Integer.parseInt(receiveEnemyCardDataIn.readUTF());
                    String newText = "Points: " + points;
                    Platform.runLater(() -> {
                        Kierki.getEnemyPlayerPoints().setText(newText);
                        // this is distusting
                        ( (AnchorPane) Kierki.getOurCardPane().getParent()).getChildren().remove(Kierki.getOurCardPane());
                        Kierki.getEnemyHandPane().getChildren().clear();
                    });
                }
            } catch (IOException e) {
                System.out.println("Socket closed");
            }
        }
    }

    private void addCardToEnemyHandView(Suit suit, Rank rank) throws IOException {
        FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/card.fxml"));
        AnchorPane card = cardLoader.load();
        Card cardController = cardLoader.getController();
        cardController.initModel(new model.Card(rank, suit));
        AnchorPane enemyHandView = Kierki.getEnemyHandPane();
        enemyHandView.getChildren().clear();
        enemyHandView.getChildren().add(card);
    }

    public void kill() {
        try {
            receiveEnemyCardSocket.close();
        } catch(Exception e) {
            System.out.println("Can't close socket");
        }
        this.isRunning = false;
    }
}
