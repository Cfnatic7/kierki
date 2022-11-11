package controllers;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Hand {

    @FXML
    private AnchorPane handPane;

    public void renderSingleCard(model.Card card) throws IOException {
        handPane.getChildren().clear();
        FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/card.fxml"));
        AnchorPane cardPane = cardLoader.load();
        Card cardController = cardLoader.getController();
        cardController.initModel(card);
        cardPane.setLayoutX(cardPane.getLayoutX() + (handPane.getWidth() / 2) - (cardPane.getWidth() / 2));
        cardPane.setLayoutY(cardPane.getLayoutY() + 75);
        System.out.println("Card rendered");
    }

    public void renderAllCards() throws IOException {
        int xOffset = 5;
        FXMLLoader loader;
        for (model.Card card : model.Table.getOurPlayerModel().getHand().getCards()) {
            loader = new FXMLLoader();
            AnchorPane cardPane = loader.load(getClass().getResource("/card.fxml").openStream());
            Card cardController = loader.getController();
            cardController.initModel(card);
            cardPane.setLayoutX(cardPane.getLayoutX() + xOffset);
            cardPane.setLayoutY(cardPane.getLayoutY() + 75);
            cardController.setInitialYLayout(cardPane.getLayoutY());

            xOffset += 40;
            handPane.getChildren().add(cardPane);
        }
    }


}
