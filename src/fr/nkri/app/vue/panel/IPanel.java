package fr.nkri.app.vue.panel;

import fr.nkri.app.vue.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {

    void init(final PanelManager panelManager);
    GridPane getLayout();
    String getStylePath();
}
