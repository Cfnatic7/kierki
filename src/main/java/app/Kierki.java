package app;

import controllers.Rooms;
import enums.RoomNumber;
import handlers.EnemyCardHandler;
import handlers.RoomHandler;
import javafx.scene.layout.AnchorPane;
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

    private final static int PORT_FOR_ENEMY_CARD = 7583;

    private Hand player;

    private Text message = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox playerOneCards = new HBox(20);

    private HBox playerTwoCards = new HBox(20);

    private static Scene scene;

    private static Stage primaryStage;

    private static Socket clientSocket;

    private static Socket roomHandlerSocket;

    private static Socket receiveEnemyCardSocket;

    private static Rooms roomsController;

    private static RoomHandler roomHandler;

    public static DataInputStream dataIn;

    public static DataOutputStream dataOut;

    public static DataInputStream roomDataIn;

    public static DataOutputStream roomDataOut;

//    private static controllers.Hand enemyhandController;

    private static EnemyCardHandler enemyCardHandler;

    private static AnchorPane enemyHandPane;

    private static Text enemyPlayerPoints;

    private static Text ourPlayerPoints;

    private static AnchorPane ourCardPane;

    private static double initialYLayout;

    private static AnchorPane ourHandPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            roomHandlerSocket = new Socket("127.0.0.1", PORT_FOR_ROOM_HANDLER);
            receiveEnemyCardSocket = new Socket("127.0.0.1", PORT_FOR_ENEMY_CARD);
            roomDataIn = new DataInputStream(roomHandlerSocket.getInputStream());
            roomDataOut = new DataOutputStream(roomHandlerSocket.getOutputStream());
            roomHandler = new RoomHandler(roomHandlerSocket);
            enemyCardHandler = new EnemyCardHandler(receiveEnemyCardSocket);
            clientSocket = new Socket("127.0.0.1", PORT);
            dataIn = new DataInputStream(clientSocket.getInputStream());
            dataOut = new DataOutputStream(clientSocket.getOutputStream());
            Kierki.primaryStage = primaryStage;
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/initial-view.fxml")));
            scene = new Scene(root);
            roomHandler.start();
            enemyCardHandler.start();
        } catch(Exception e) {
            roomHandler.kill();
            roomHandler.join();
            enemyCardHandler.kill();
            enemyCardHandler.join();
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
            enemyCardHandler.kill();
            try {
                roomDataOut.close();
                roomDataIn.close();
                dataOut.close();
                dataIn.close();
                receiveEnemyCardSocket.close();
            } catch(Exception e) {
                System.out.println("Can't close socket streams");
            }
            try {
                roomHandler.join();
                enemyCardHandler.join();
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

    public static void setRoomsController(Rooms rs) {
        roomsController = rs;
    }

    public static Rooms getRoomsController() {
        return roomsController;
    }

//    public static controllers.Hand getEnemyhandController() {
//        return enemyhandController;
//    }
//
//    public static void setEnemyhandController(controllers.Hand enemyhandController) {
//        Kierki.enemyhandController = enemyhandController;
//    }

    public static AnchorPane getEnemyHandPane() {
        return enemyHandPane;
    }

    public static void setEnemyHandPane(AnchorPane enemyHandPane) {
        Kierki.enemyHandPane = enemyHandPane;
    }

    public static Text getEnemyPlayerPoints() {
        return enemyPlayerPoints;
    }

    public static Text getOurPlayerPoints() {
        return ourPlayerPoints;
    }

    public static void setEnemyPlayerPoints(Text enemyPlayerPoints) {
        Kierki.enemyPlayerPoints = enemyPlayerPoints;
    }

    public static void setOurPlayerPoints(Text ourPlayerPoints) {
        Kierki.ourPlayerPoints = ourPlayerPoints;
    }

    public static AnchorPane getOurCardPane() {
        return ourCardPane;
    }

    public static void setOurCardPane(AnchorPane ourCardPane) {
        Kierki.ourCardPane = ourCardPane;
    }

    public static double getInitialYLayout() {
        return initialYLayout;
    }

    public static void setInitialYLayout(double initialYLayout) {
        Kierki.initialYLayout = initialYLayout;
    }

    public static AnchorPane getOurHandPane() {
        return ourHandPane;
    }

    public static void setOurHandPane(AnchorPane ourHandPane) {
        Kierki.ourHandPane = ourHandPane;
    }
}