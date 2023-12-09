package fr.nkri.app.vue.panels.guis;

import fr.nkri.app.vue.PanelManager;
import fr.nkri.app.vue.panel.Panel;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

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
        mainPane.add(titleLabel, 0, 0, 2, 1);

        nameField.setPromptText("Nom de votre item");
        mainPane.add(nameField, 0, 1, 2, 1);

        final Button buttonKits = new Button("Kits");
        final Button buttonItem = new Button("Items");

        mainPane.add(buttonKits, 0, 2);
        mainPane.add(buttonItem, 1, 2);

        buttonKits.setOnAction(event -> clickButtonKits());
        buttonItem.setOnAction(event -> clickButtonItem());

        getLayout().getChildren().add(mainPane);
    }

    private void clickButtonKits(){
        if(nameField.getText().length() == 0){
            sendAlert("Erreur", "Veuillez entrer le nom de votre item");
            return;
        }
    }

    private void clickButtonItem(){
        if(nameField.getText().length() == 0){
            sendAlert("Erreur", "Veuillez entrer le nom de votre item");
            return;
        }
    }

    @Override
    public String getStylePath() {
        return "fr/nkri/app/css/main_menu.css";
    }

    private void sendAlert(final String title, final String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(content);
        alert.show();
    }
}
