package handlers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class RoomHandler extends Thread {

    private DataInputStream dataIn;

    private DataOutputStream dataOut;

    public RoomHandler(Socket roomSocket) throws IOException {
        dataIn = new DataInputStream(roomSocket.getInputStream());
        dataOut = new DataOutputStream(roomSocket.getOutputStream());
    }

    @Override
    public void run() {

    }
}
