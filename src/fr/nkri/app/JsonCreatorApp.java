package fr.nkri.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nkri.app.managers.models.enums.ItemDisplay;
import fr.nkri.app.managers.models.ItemModel;
import fr.nkri.app.managers.models.enums.ParentType;
import javafx.application.Application;
import javafx.stage.Stage;

public class JsonCreatorApp extends Application {

    private static Gson GSON;

    public static void main(String[] args) {
        GSON = getGsonBuilder().create();
        final ItemModel itemModel = new ItemModel("ruby_ore", ParentType.BLOCK, ItemDisplay.ITEM_BLOCK);
        final String json = itemModel.toJson();

        System.out.println(json);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

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