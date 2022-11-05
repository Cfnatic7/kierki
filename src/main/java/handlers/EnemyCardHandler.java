package handlers;

import app.Kierki;
import enums.Commands;
import enums.Rank;
import enums.Suit;
import javafx.application.Platform;
import model.Card;

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
                            Kierki.getEnemyhandController().renderSingleCard(new Card(rank, suit));
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

    public void kill() {
        try {
            receiveEnemyCardSocket.close();
        } catch(Exception e) {
            System.out.println("Can't close socket");
        }
        this.isRunning = false;
    }
}
