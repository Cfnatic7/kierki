package controllers;

import Exceptions.EmptyDeckException;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Hand {

    public AnchorPane cardsInPossesion;
    private model.Hand handModel;

    public model.Hand getHandModel() {
        return this.handModel;
    }

    public void initModel(model.Hand hand) throws EmptyDeckException, IOException {
        if (this.handModel != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        handModel = hand;
        handModel.drawCardsFromDeck();
        this.renderAllCards();
    }

    private void renderAllCards() throws IOException {
        int xOffset = 5;
        FXMLLoader loader;
        for (SimpleObjectProperty<model.Card> card : handModel.getCards()) {
            loader = new FXMLLoader();
            AnchorPane cardPane = loader.load(getClass().getResource("/card.fxml").openStream());
            Card cardController = loader.getController();
            cardController.initModel(card);
            cardPane.setLayoutX(cardPane.getLayoutX() + xOffset);
            cardPane.setLayoutY(cardPane.getLayoutY() + 75);

            xOffset += 50;
            cardsInPossesion.getChildren().add(cardPane);
        }
    }


}
