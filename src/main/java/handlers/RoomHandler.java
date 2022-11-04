package handlers;

import app.Kierki;
import enums.RoomNumber;
import enums.ServerResponses;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RoomHandler extends Thread {

    private DataInputStream dataIn;

    private DataOutputStream dataOut;

    private boolean isRunning = false;

    public RoomHandler(Socket roomSocket) throws IOException {
        dataIn = new DataInputStream(roomSocket.getInputStream());
        dataOut = new DataOutputStream(roomSocket.getOutputStream());
    }

    @Override
    public void run() {
        String response;
        System.out.println("Entered room handler");
        while (isRunning) {
            try {
                response = dataIn.readUTF();
                System.out.println("Received response");
                RoomNumber roomNumber = RoomNumber.valueOf(response);
                response = dataIn.readUTF();
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
            model.Rooms.setIsFirstRoomFree(serverResponse != ServerResponses.ROOM_FULL);
            System.out.println("Set room " + roomNumber.name() + " to " + serverResponse.name() + " state");
        }
        else if (roomNumber == RoomNumber.TWO) {
            model.Rooms.setIsSecondRoomFree(serverResponse != ServerResponses.ROOM_FULL);
            System.out.println("Set room " + roomNumber.name() + " to " + serverResponse.name() + " state");
        }
        else if (roomNumber == RoomNumber.THREE) {
            model.Rooms.setIsThirdRoomFree(serverResponse != ServerResponses.ROOM_FULL);
            System.out.println("Set room " + roomNumber.name() + " to " + serverResponse.name() + " state");
        }
        else if (roomNumber == RoomNumber.FOUR) {
            model.Rooms.setIsFourthRoomFree(serverResponse != ServerResponses.ROOM_FULL);
            System.out.println("Set room " + roomNumber.name() + " to " + serverResponse.name() + " state");
        }
    }

    public void kill() {
        this.isRunning = false;
    }
}
