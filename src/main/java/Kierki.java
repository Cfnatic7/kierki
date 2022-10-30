import content.Deck;
import content.Hand;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.util.Objects;

public class Kierki extends Application {

    private static final int EXIT_SUCCESS = 0;

    private Deck deck = new Deck(); //for mocking

    private Hand player;

    private Text message = new Text();

    private SimpleBooleanProperty playable = new SimpleBooleanProperty(false);

    private HBox playerOneCards = new HBox(20);

    private HBox playerTwoCards = new HBox(20);

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/initial-view.fxml")));
            scene = new Scene(root);
        } catch(Exception e) {
            e.printStackTrace();
        }
        Platform.setImplicitExit(true);
        primaryStage.setOnCloseRequest((ae) -> {
            Platform.exit();
            System.exit(EXIT_SUCCESS);
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}