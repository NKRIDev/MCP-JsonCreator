package fr.nkri.app.vue;

import fr.nkri.app.vue.panel.IPanel;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {

    private Stage stage;
    private GridPane layout;
    private final GridPane contentPane = new GridPane();

    public PanelManager(final Stage stage){
        this.stage = stage;
    }

    public void init(){
        stage.setTitle("MCP-JsonCreator");
        stage.setWidth(1280);
        stage.setHeight(720);
        stage.initStyle(StageStyle.DECORATED);
        stage.centerOnScreen();

        this.layout = new GridPane();
        final Scene scene = new Scene(layout);

        stage.setScene(scene);

        this.layout.add(contentPane, 0, 1);
        GridPane.setVgrow(contentPane, Priority.ALWAYS);
        GridPane.setHgrow(contentPane, Priority.ALWAYS);
        stage.show();
    }

    public void showPanel(final IPanel iPanel){
        contentPane.getChildren().clear();
        contentPane.getChildren().add(iPanel.getLayout());

        if(iPanel.getStylePath() != null){
            stage.getScene().getStylesheets().clear();
            stage.getScene().getStylesheets().add(iPanel.getStylePath());
        }

        iPanel.init(this);
    }
}
