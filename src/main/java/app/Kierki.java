package app;

import handlers.RoomHandler;
import model.Deck;
import model.Hand;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;

public class Kierki extends Application {

    private static final int EXIT_SUCCESS = 0;

    private Deck deck = new Deck(); //for mocking

    private final static int PORT = 8372;

    private final static int PORT_FOR_ROOM_HANDLER = 7482;

    private Hand player;

    private Text message = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox playerOneCards = new HBox(20);

    private HBox playerTwoCards = new HBox(20);

    private static Scene scene;

    private static Stage primaryStage;

    private static Socket clientSocket;

    private static Socket roomHandlerSocket;

    private static RoomHandler roomHandler;

    public static DataInputStream dataIn;

    public static DataOutputStream dataOut;

    public static DataInputStream roomDataIn;

    public static DataOutputStream roomDataOut;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            roomHandlerSocket = new Socket("127.0.0.1", PORT_FOR_ROOM_HANDLER);
            roomDataIn = new DataInputStream(roomHandlerSocket.getInputStream());
            roomDataOut = new DataOutputStream(roomHandlerSocket.getOutputStream());
            roomHandler = new RoomHandler(roomHandlerSocket);
            clientSocket = new Socket("127.0.0.1", PORT);
            dataIn = new DataInputStream(clientSocket.getInputStream());
            dataOut = new DataOutputStream(clientSocket.getOutputStream());
            Kierki.primaryStage = primaryStage;
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/initial-view.fxml")));
            scene = new Scene(root);
            roomHandler.start();
        } catch(Exception e) {
            roomHandler.kill();
            roomHandler.join();
            e.printStackTrace();
        }
        Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest((ae) -> {
            try {
                model.LoginForm.handleLogout();
            } catch (IOException e) {
                System.out.println("Can't logout");
            }
            Platform.exit();
            roomHandler.kill();
            try {
                roomDataOut.close();
                roomDataIn.close();
                dataOut.close();
                dataIn.close();
            } catch(Exception e) {
                System.out.println("Can't close socket streams");
            }
            try {
                roomHandler.join();
            } catch (InterruptedException e) {
                System.out.println("Can't join room handler thread");
            }
            System.exit(EXIT_SUCCESS);
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }

    public static Scene getScene() {
        return scene;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}