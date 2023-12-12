package fr.nkri.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.nkri.app.managers.models.items.ItemModel;
import javafx.application.Application;

import javax.swing.*;

public class JsonCreatorMain {

    public static void main(String[] args) {
        hasJavaFX(args);
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
}
