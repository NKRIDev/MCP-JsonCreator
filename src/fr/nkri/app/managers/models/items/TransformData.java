package fr.nkri.app.managers.models.items;

import com.google.gson.annotations.Expose;

public class TransformData{

    @Expose(serialize = true)
    private float[] rotation, translation, scale;

    public TransformData(final float[] rotation, final float[] translation, final float[] scale){
        this.rotation = rotation;
        this.translation = translation;
        this.scale = scale;
    }

    public float[] getRotation() {
        return rotation;
    }

    public float[] getTranslation() {
        return translation;
    }

    public float[] getScale() {
        return scale;
    }

    public void setRotation(float[] rotation) {
        this.rotation = rotation;
    }

    public void setScale(float[] scale) {
        this.scale = scale;
    }

    public void setTranslation(float[] translation) {
        this.translation = translation;
    }
}