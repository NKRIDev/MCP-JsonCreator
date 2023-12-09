package fr.nkri.app;

import fr.nkri.app.vue.PanelManager;
import fr.nkri.app.vue.panels.guis.MainPanel;
import javafx.application.Application;
import javafx.stage.Stage;
import sun.applet.Main;

public class JsonCreatorApp extends Application {

    private PanelManager panelManager;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.panelManager = new PanelManager(primaryStage);
        this.panelManager.init();

        this.panelManager.showPanel(new MainPanel());
    }
}
