package handlers;

import app.Kierki;
import controllers.Card;
import enums.Commands;
import enums.Rank;
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
                Commands command = Commands.valueOf(receiveEnemyCardDataIn.readUTF());
                if (command == Commands.SEND_ENEMY_CARD) {
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
