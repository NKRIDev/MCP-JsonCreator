package fr.nkri.app.managers.models.enums;

import fr.nkri.app.managers.models.TransformData;

import java.util.ArrayList;
import java.util.List;

public enum ItemDisplay {

    ITEM_NORMAL(new TransformData(new float[]{-90.0F, 0.0F, 0.0F}, new float[]{0.0F, 1.0F, -3.0F}, new float[]{0.55F, 0.55F, 0.55F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),

    ITEM_AXE(new TransformData(new float[]{0.0F, 90.0F, -35.0F}, new float[]{0.0F, 1.25F, -3.5F}, new float[]{0.85F, 0.85F, 0.85F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),

    ITEM_SHOVEL(new TransformData(new float[]{0.0F, 90.0F, -35.0F}, new float[]{0.0F, 1.25F, -3.5F}, new float[]{0.85F, 0.85F, 0.85F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),
    ITEM_HOE(new TransformData(new float[]{0.0F, 90.0F, -35.0F}, new float[]{0.0F, 1.25F, -3.5F}, new float[]{0.85F, 0.85F, 0.85F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),

    ITEM_PICKAXE(new TransformData(new float[]{0.0F, 90.0F, -35.0F}, new float[]{0.0F, 1.25F, -3.5F}, new float[]{0.85F, 0.85F, 0.85F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),
    ITEM_SWORD(new TransformData(new float[]{0.0F, 90.0F, -35.0F}, new float[]{0.0F, 1.25F, -3.5F}, new float[]{0.85F, 0.85F, 0.85F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),

    ITEM_BLOCK(new TransformData(new float[]{10.0F, -45.0F, 170.0F}, new float[]{0.0F, 1.5F, -2.75F}, new float[]{0.375F, 0.375F, 0.375F}), null),

    ITEM_HELMET(new TransformData(new float[]{-90.0F, 0.0F, 0.0F}, new float[]{ 0.0F, 1.0F, -2.5F}, new float[]{0.55F, 0.55F, 0.55F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),

    ITEM_CHESTPLATE(new TransformData(new float[]{-90.0F, 0.0F, 0.0F}, new float[]{ 0.0F, 1.0F, -3.0F}, new float[]{0.55F, 0.55F, 0.55F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),

    ITEM_LEGGINGS(new TransformData(new float[]{-90.0F, 0.0F, 0.0F}, new float[]{ 0.0F, 1.0F, -3.0F}, new float[]{0.55F, 0.55F, 0.55F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),

    ITEM_BOOTS(new TransformData(new float[]{-90.0F, 0.0F, 0.0F}, new float[]{ 0.0F, 1.0F, -2.5F}, new float[]{0.55F, 0.55F, 0.55F}),
            new TransformData(new float[]{0.0F, -135.0F, 25.0F}, new float[]{0.0F, 4.0F, 2.0F}, new float[]{1.7F, 1.7F, 1.7F})),
    ;

    private TransformData thirdperson, firstperson;

    private ItemDisplay(final TransformData thirdperson, final TransformData firstperson){
        this.thirdperson = thirdperson;
        this.firstperson = firstperson;
    }

    public TransformData getFirstperson() {
        return firstperson;
    }

    public TransformData getThirdperson() {
        return thirdperson;
    }
}
