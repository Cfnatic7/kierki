package controllers;

import Exceptions.EmptyDeckException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Hand {
    public AnchorPane cardsInPossesion;

    private void renderAllCards() throws IOException {
        int xOffset = 5;
        FXMLLoader loader;
        for (SimpleObjectProperty<model.Card> card : model.Table.getOurPlayerModel().getHand().getCards()) {
            loader = new FXMLLoader();
            AnchorPane cardPane = loader.load(getClass().getResource("/card.fxml").openStream());
            Card cardController = loader.getController();
            cardController.initModel(card);
            cardPane.setLayoutX(cardPane.getLayoutX() + xOffset);
            cardPane.setLayoutY(cardPane.getLayoutY() + 75);
            cardController.setInitialYLayout(cardPane.getLayoutY());

            xOffset += 40;
            cardsInPossesion.getChildren().add(cardPane);
        }
    }


}
