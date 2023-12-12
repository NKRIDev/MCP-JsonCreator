package fr.nkri.app.vue.panels.guis;

import fr.nkri.app.JsonCreatorApp;
import fr.nkri.app.JsonCreatorMain;
import fr.nkri.app.managers.models.block.BlockModel;
import fr.nkri.app.managers.models.blockstate.BlockStateModel;
import fr.nkri.app.managers.models.items.ItemModel;
import fr.nkri.app.managers.models.items.enums.ItemDisplay;
import fr.nkri.app.managers.models.items.enums.ParentType;
import fr.nkri.app.vue.PanelManager;
import fr.nkri.app.vue.panel.Panel;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MainPanel extends Panel {

    private GridPane mainPane = new GridPane();
    private TextField nameField = new TextField();

    public MainPanel(){}

    @Override
    public void init(PanelManager panelManager) {
        super.init(panelManager);

        mainPane.getStyleClass().add("main-pane");
        mainPane.setAlignment(Pos.CENTER);
        setCenterV(mainPane);
        setCenterH(mainPane);
        setCanTakeAllSize(mainPane);
        setTop(mainPane);

        final Label titleLabel = new Label("JsonCreator");
        titleLabel.setFont(Font.font("Inter", FontWeight.BOLD, FontPosture.REGULAR, 20));
        setCenterH(titleLabel);
        setCenterV(titleLabel);
        mainPane.add(titleLabel, 0, 0, 2, 1);

        nameField.setPromptText("Nom de votre item");
        setCenterH(nameField);
        setCenterV(nameField);
        mainPane.add(nameField, 0, 1, 2, 1);

        final Button buttonKits = new Button("Kits");
        final Button buttonItem = new Button("Items");
        final Button buttonAxe = new Button("Hâche");

        mainPane.add(buttonKits, 0, 2);
        mainPane.add(buttonItem, 1, 2);

        buttonKits.setOnAction(event -> clickButtonKits());
        buttonItem.setOnAction(event -> clickButtonItem());

        getLayout().getChildren().add(mainPane);
    }

    private void clickButtonKits(){
        if(nameField.getText().length() == 0){
            sendAlert("Erreur", "Veuillez entrer le nom de votre item", Alert.AlertType.ERROR);
            return;
        }

        final File path = getDirectoryPath();
        final List<ItemModel> itemModelList = new ArrayList<>();

        for(ItemDisplay itemDisplay : ItemDisplay.values()) {
            if (itemDisplay != ItemDisplay.ITEM_BLOCK) {
                final ItemModel itemModel = new ItemModel(nameField.getText() + itemDisplay.getSuffix(), ParentType.BUILTIN, itemDisplay);

                itemModelList.add(itemModel);
            }
        }

        final File pathModelItems = new File(path.toString().concat("/item"));

        if(!pathModelItems.exists()){
            pathModelItems.mkdirs();
        }

        for(ItemModel itemModel : itemModelList){
            final File newFile = new File(pathModelItems, itemModel.getItemName() + ".json");
            final String json = itemModel.toJson();

            try {
                final FileWriter writer = new FileWriter(newFile);
                writer.write(json);
                writer.close();

                sendAlert("Confirmation", "Vous venez de sauvegarder le fichier json de " + itemModel.getItemName(), Alert.AlertType.CONFIRMATION);
            }
            catch (IOException e) {
                sendAlert("Erreur", "Une erreur est survenue: \n" + e.getMessage(), Alert.AlertType.ERROR);
                e.printStackTrace();
            }
        }

        final BlockModel oreModel = new BlockModel(nameField.getText() + "_ore");
        final BlockModel blockModel = new BlockModel(nameField.getText() + "_block");

        final File pathModelBlock = new File(path.toString().concat("/block"));

        if(!pathModelBlock.exists()){
            pathModelBlock.mkdirs();
        }

        final File newFile = new File(pathModelBlock, oreModel.getBlockName() + ".json");
        final String jsonOre = oreModel.toJson();

        try {
            final FileWriter writer = new FileWriter(newFile);
            writer.write(jsonOre);
            writer.close();

            sendAlert("Confirmation", "Vous venez de sauvegarder le fichier json de " + oreModel.getBlockName(), Alert.AlertType.CONFIRMATION);
        }
        catch (IOException e) {
            sendAlert("Erreur", "Une erreur est survenue: \n" + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }

        final File newFiles = new File(pathModelBlock, blockModel.getBlockName() + ".json");
        final String jsonblock = blockModel.toJson();

        try {
            final FileWriter writer = new FileWriter(newFiles);
            writer.write(jsonblock);
            writer.close();

            sendAlert("Confirmation", "Vous venez de sauvegarder le fichier json de " + blockModel.getBlockName(), Alert.AlertType.CONFIRMATION);
        }
        catch (IOException e) {
            sendAlert("Erreur", "Une erreur est survenue: \n" + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }

        //STATE
        final BlockStateModel oreStateModel = new BlockStateModel(nameField.getText() + "_ore");
        final BlockStateModel blockStateModel = new BlockStateModel(nameField.getText() + "_block");

        final File pathModelBlockState = new File(path.toString().concat("/blockstate"));

        if(!pathModelBlockState.exists()){
            pathModelBlockState.mkdirs();
        }

        final File oreStateFile = new File(pathModelBlockState, oreStateModel.getBlockStateName() + ".json");
        final String jsonStateOre = oreStateModel.toJson();

        try {
            final FileWriter writer = new FileWriter(oreStateFile);
            writer.write(jsonStateOre);
            writer.close();

            sendAlert("Confirmation", "Vous venez de sauvegarder le fichier json de " + oreStateModel.getBlockStateName(), Alert.AlertType.CONFIRMATION);
        }
        catch (IOException e) {
            sendAlert("Erreur", "Une erreur est survenue: \n" + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }

        final File blockStateFile = new File(pathModelBlockState, blockStateModel.getBlockStateName() + ".json");
        final String jsonBlockState = blockStateModel.toJson();

        try {
            final FileWriter writer = new FileWriter(blockStateFile);
            writer.write(jsonBlockState);
            writer.close();

            sendAlert("Confirmation", "Vous venez de sauvegarder le fichier json de " + blockStateModel.getBlockStateName(), Alert.AlertType.CONFIRMATION);
        }
        catch (IOException e) {
            sendAlert("Erreur", "Une erreur est survenue: \n" + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    private void clickButtonItem(){
        if(nameField.getText().length() == 0) {
            sendAlert("Erreur", "Veuillez entrer le nom de votre item", Alert.AlertType.ERROR);
            return;
        }

        final File path = getDirectoryPath();
        final ItemModel itemModel = new ItemModel(nameField.getText(), ParentType.BUILTIN, ItemDisplay.ITEM_NORMAL);
        final File newFile = new File(path, itemModel.getItemName() + ".json");
        final String json = itemModel.toJson();

        try {
            final FileWriter writer = new FileWriter(newFile);
            writer.write(json);
            writer.close();

            sendAlert("Confirmation", "Vous venez de sauvegarder le fichier json de " + itemModel.getItemName(), Alert.AlertType.CONFIRMATION);
        }
        catch (IOException e) {
            sendAlert("Erreur", "Une erreur est survenue: \n" + e.getMessage(), Alert.AlertType.ERROR);
            e.printStackTrace();
        }
    }

    @Override
    public String getStylePath() {
        return "fr/nkri/app/css/main_menu.css";
    }

    private void sendAlert(final String title, final String content, final Alert.AlertType alertType){
        final Alert alert = new Alert(alertType);

        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.show();
    }

    private File getDirectoryPath() {
        final DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choisissez un dossier");
        final File selectedDirectory = directoryChooser.showDialog(getPanelManager().getStage());

        return selectedDirectory;
    }
}
