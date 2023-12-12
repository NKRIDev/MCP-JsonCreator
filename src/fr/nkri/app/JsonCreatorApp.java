package fr.nkri.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nkri.app.vue.PanelManager;
import fr.nkri.app.vue.panels.guis.MainPanel;
import javafx.application.Application;
import javafx.stage.Stage;
import sun.applet.Main;

public class JsonCreatorApp extends Application {

    private static Gson GSON;
    private PanelManager panelManager;


    @Override
    public void start(Stage primaryStage) throws Exception {
        GSON = getGsonBuilder().create();

        this.panelManager = new PanelManager(primaryStage);
        this.panelManager.init();

        this.panelManager.showPanel(new MainPanel());
    }

    private static GsonBuilder getGsonBuilder(){
        return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().excludeFieldsWithoutExposeAnnotation();
    }

    public static String serialize(final Object obj){
        return getGson().toJson(obj);
    }

    public static Gson getGson() {
        return GSON;
    }
}
