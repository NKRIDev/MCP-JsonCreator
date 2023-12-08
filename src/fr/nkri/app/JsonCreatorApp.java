package fr.nkri.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nkri.app.managers.models.block.BlockModel;
import fr.nkri.app.managers.models.blockstate.BlockStateModel;
import javafx.application.Application;
import javafx.stage.Stage;

public class JsonCreatorApp extends Application {

    private static Gson GSON;

    public static void main(String[] args) {
        GSON = getGsonBuilder().create();
        final BlockStateModel model = new BlockStateModel("ruby_ore");
        final String json = model.toJson();

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
