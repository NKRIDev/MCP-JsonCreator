package fr.nkri.app.vue.panel;

import fr.nkri.app.vue.PanelManager;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

public abstract class Panel implements IMovable, IPanel, ITakePlace{

    protected GridPane layout = new GridPane();
    protected PanelManager panelManager;

    public Panel(){}

    @Override
    public void init(PanelManager panelManager) {
        this.panelManager = panelManager;
        setCanTakeAllSize(getLayout());
    }

    @Override
    public GridPane getLayout() {
        return layout;
    }

    @Override
    public String getStylePath() {
        return null;
    }

    @Override
    public void setLeft(Node node) {
        GridPane.setHalignment(node, HPos.LEFT);
    }

    @Override
    public void setRight(Node node) {
        GridPane.setHalignment(node, HPos.RIGHT);
    }

    @Override
    public void setTop(Node node) {
        GridPane.setValignment(node, VPos.TOP);
    }

    @Override
    public void setBottom(Node node) {
        GridPane.setValignment(node, VPos.BOTTOM);
    }

    @Override
    public void setBaseLine(Node node) {
        GridPane.setValignment(node, VPos.BASELINE);
    }

    @Override
    public void setCenterH(Node node) {
        GridPane.setHalignment(node, HPos.CENTER);
    }

    @Override
    public void setCenterV(Node node) {
        GridPane.setValignment(node, VPos.CENTER);
    }

    public PanelManager getPanelManager() {
        return panelManager;
    }
}
