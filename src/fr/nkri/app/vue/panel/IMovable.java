package fr.nkri.app.vue.panel;

import javafx.scene.Node;

public interface IMovable {

    void setLeft(final Node left);
    void setRight(final Node right);
    void setTop(final Node top);
    void setBottom(final Node bottom);
    void setBaseLine(final Node baseLine);
    void setCenterH(final Node centerH);
    void setCenterV(final Node centerV);
}
