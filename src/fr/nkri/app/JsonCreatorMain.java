package fr.nkri.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;

import javax.swing.*;

public class JsonCreatorMain {

    private static Gson GSON;

    public static void main(String[] args) {
        if(hasJavaFX(args)){
            GSON = getGsonBuilder().create();
           // final ItemModel itemModel = new ItemModel("ruby_axe", ParentType.BUILTIN, ItemDisplay.ITEM_AXE);
            //final String json = itemModel.toJson();

            //System.out.println(json);
        }
    }

    private static boolean hasJavaFX(final String[] args){
        try {
            Class.forName("javafx.application.Application");
            Application.launch(JsonCreatorApp.class, args);
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erreur: \n" + e.getMessage() + " not found", "Erreur", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
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
