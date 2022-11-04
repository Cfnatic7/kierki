package model;

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


    public synchronized void setIsFirstRoomFree(boolean value) {
        isFirstRoomFree.setValue(value);
    }

    public synchronized void setIsSecondRoomFree(boolean value) {
        isSecondRoomFree.setValue(value);
    }

    public synchronized void setIsThirdRoomFree(boolean value) {
        isThirdRoomFree.setValue(value);
    }

    public synchronized void setIsFourthRoomFree(boolean value) {
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

    public static void handleRoomJoin(RoomNumber roomNumber) throws IOException, InternalServerErrorException {
        Kierki.dataOut.writeUTF(Commands.JOIN_ROOM.name());
        String response = Kierki.dataIn.readUTF();
        if (!response.equals(ServerResponses.OK.name())) {
            throw new InternalServerErrorException();
        }
        Kierki.dataOut.writeUTF(roomNumber.name());
        response = Kierki.dataIn.readUTF();
        if (!response.equals(ServerResponses.OK.name())) {
            throw new InternalServerErrorException();
        }
    }

}
