package Exceptions;

public class InternalServerErrorException extends Exception {

    public InternalServerErrorException() {
        super("Server didn't respond");
    }
}
