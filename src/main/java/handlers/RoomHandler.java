package handlers;

import app.Kierki;
import controllers.Rooms;
import enums.RoomNumber;
import enums.ServerResponses;
import javafx.application.Platform;
import java.io.IOException;
import java.net.Socket;

public class RoomHandler extends Thread {


    private boolean isRunning = true;

    public RoomHandler(Socket roomSocket) {
    }

    @Override
    public void run() {
        String response;
        System.out.println("Entered room handler");
        while (isRunning) {
            try {
                System.out.println("Waiting for server notification");
                response = Kierki.roomDataIn.readUTF();
                System.out.println("Received response");
                RoomNumber roomNumber = RoomNumber.valueOf(response);
                response = Kierki.roomDataIn.readUTF();
                ServerResponses serverResponse = ServerResponses.valueOf(response);
                handleRoomNumberResponse(roomNumber, serverResponse);
            } catch (IOException e) {
                System.out.println("Room handler can't receive response");
                kill();
            }
        }
    }

    private void handleRoomNumberResponse(RoomNumber roomNumber, ServerResponses serverResponse) {
        if (roomNumber == RoomNumber.ONE) {
            Platform.runLater(() -> {
                Rooms rooms = Kierki.getRoomsController();
                if (rooms != null) {
                    rooms.firstRoom.setDisable(serverResponse == ServerResponses.ROOM_FULL);
                }

            });
            System.out.println("Set room " + roomNumber.name() + " to " + serverResponse.name() + " state");
        }
        else if (roomNumber == RoomNumber.TWO) {
            Platform.runLater(() -> {
                Rooms rooms = Kierki.getRoomsController();
                if (rooms != null) {
                    rooms.secondRoom.setDisable(serverResponse == ServerResponses.ROOM_FULL);
                }
            });
            System.out.println("Set room " + roomNumber.name() + " to " + serverResponse.name() + " state");
        }
        else if (roomNumber == RoomNumber.THREE) {
            Platform.runLater(() -> {
                Rooms rooms = Kierki.getRoomsController();
                if (rooms != null) {
                    rooms.thirdRoom.setDisable(serverResponse == ServerResponses.ROOM_FULL);
                }
            });
            System.out.println("Set room " + roomNumber.name() + " to " + serverResponse.name() + " state");
        }
        else if (roomNumber == RoomNumber.FOUR) {
            Platform.runLater(() -> {
                Rooms rooms = Kierki.getRoomsController();
                if (rooms != null) {
                    rooms.fourthRoom.setDisable(serverResponse == ServerResponses.ROOM_FULL);
                }
            });
            System.out.println("Set room " + roomNumber.name() + " to " + serverResponse.name() + " state");
        }
    }

    public void kill() {
        this.isRunning = false;
    }
}
