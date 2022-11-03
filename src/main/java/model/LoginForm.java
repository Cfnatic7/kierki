package model;

import Exceptions.BadRequestException;
import app.Kierki;
import enums.Commands;
import enums.ServerResponses;

import java.io.IOException;

public class LoginForm {

    public static void handleLogin(String login, String password) throws IOException, BadRequestException {
        Kierki.dataOut.writeUTF(Commands.LOGIN.name());
        String response = Kierki.dataIn.readUTF();
        if (!response.equals(ServerResponses.OK.name())) {
            throw new BadRequestException("Server didn't respond");
        }
        Kierki.dataOut.writeUTF(login);
        response = Kierki.dataIn.readUTF();
        if (!response.equals(ServerResponses.OK.name())) {
            throw new BadRequestException("Server didn't respond");
        }
        Kierki.dataOut.writeUTF(password);
        response = Kierki.dataIn.readUTF();
        if (!response.equals(ServerResponses.OK.name())) {
            throw new BadRequestException("Wrong login");
        }
    }

}
