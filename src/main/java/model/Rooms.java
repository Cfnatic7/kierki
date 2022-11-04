package model;

import Exceptions.BadRequestException;
import Exceptions.InternalServerErrorException;
import app.Kierki;
import enums.Commands;
import enums.RoomNumber;
import enums.ServerResponses;
import javafx.beans.property.SimpleBooleanProperty;

import java.io.IOException;

public class Rooms {

    private static final SimpleBooleanProperty isFirstRoomFree = new SimpleBooleanProperty(true);

    private static final SimpleBooleanProperty isSecondRoomFree = new SimpleBooleanProperty(true);

    private static final SimpleBooleanProperty isThirdRoomFree = new SimpleBooleanProperty(true);

    private static final SimpleBooleanProperty isFourthRoomFree = new SimpleBooleanProperty(true);


    public static synchronized void setIsFirstRoomFree(boolean value) {
        isFirstRoomFree.setValue(value);
    }

    public static synchronized void setIsSecondRoomFree(boolean value) {
        isSecondRoomFree.setValue(value);
    }

    public static synchronized void setIsThirdRoomFree(boolean value) {
        isThirdRoomFree.setValue(value);
    }

    public static synchronized void setIsFourthRoomFree(boolean value) {
        isFourthRoomFree.setValue(value);
    }

    public static SimpleBooleanProperty getIsFirstRoomFree() {
        return isFirstRoomFree;
    }

    public static SimpleBooleanProperty getIsSecondRoomFree() {
        return isFirstRoomFree;
    }

    public static SimpleBooleanProperty getIsThirdRoomFree() {
        return isFirstRoomFree;
    }

    public static SimpleBooleanProperty getIsFourthRoomFree() {
        return isFirstRoomFree;
    }

    public static void handleRoomJoin(RoomNumber roomNumber) throws IOException, BadRequestException {
        Kierki.dataOut.writeUTF(Commands.JOIN_ROOM.name());
        String response = Kierki.dataIn.readUTF();
        System.out.println("First response in handle room join: " + response);

        if (!response.equals(ServerResponses.OK.name())) {
            throw new BadRequestException("Can't join room");
        }
        Kierki.dataOut.writeUTF(roomNumber.name());
        response = Kierki.dataIn.readUTF();
        System.out.println("Second response in handle room join: " + response);
        if (!response.equals(ServerResponses.OK.name())) {
            throw new BadRequestException("Can't join room");
        }
        System.out.println("Joined room " + roomNumber.name());
    }

}
