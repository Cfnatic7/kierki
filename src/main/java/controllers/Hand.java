package controllers;

import Exceptions.EmptyDeckException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Hand {

    private model.Hand handModel;

    public model.Hand getHandModel() {
        return this.handModel;
    }

    public void initModel() throws EmptyDeckException, IOException {
        if (this.handModel != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        handModel = new model.Hand();
        handModel.drawCardsFromDeck();
        this.renderAllCards();
    }

    private void renderAllCards() throws IOException {
        int xOffset = 0;
        for (SimpleObjectProperty<model.Card> card : handModel.getCards()) {
            FXMLLoader cardLoader = new FXMLLoader(getClass().getResource("/card.fxml"));
            AnchorPane cardPane = cardLoader.load();
            Card cardController = cardLoader.getController();
            cardController.initModel(card);
            cardPane.setLayoutX(cardPane.getLayoutX() + xOffset);
            xOffset += 10;
        }
    }


}
