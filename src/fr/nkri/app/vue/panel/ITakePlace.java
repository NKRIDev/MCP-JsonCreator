package fr.nkri.app.vue.panel;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public interface ITakePlace {

    default void setCanTakeAllSize(final Node canTakeAllSize){
        GridPane.setHgrow(canTakeAllSize, Priority.ALWAYS);
        GridPane.setVgrow(canTakeAllSize, Priority.ALWAYS);
    }
}