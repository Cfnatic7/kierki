package model;

import javafx.beans.property.SimpleBooleanProperty;

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

}
