package fr.nkri.app.managers.models.items;

import com.google.gson.annotations.Expose;
import fr.nkri.app.JsonCreatorApp;
import fr.nkri.app.managers.models.items.enums.ItemDisplay;
import fr.nkri.app.managers.models.items.enums.ParentType;

import java.util.HashMap;
import java.util.Map;

public class ItemModel {

    @Expose(serialize = false)
    private String itemName;
    @Expose(serialize = false)
    private ParentType parentType;
    @Expose(serialize = true)
    private String parent;
    @Expose(serialize = true)
    private Map<String, String> textures;
    @Expose(serialize = false)
    private ItemDisplay itemDisplay;
    @Expose(serialize = true)
    private Display display;

    public ItemModel(final String itemName, final ParentType parentType, final ItemDisplay itemDisplay){
        this.itemName = itemName;

        if(parentType != ParentType.BLOCK){
            this.parent = parentType.getParent();
            this.textures = new HashMap<>();

            this.textures.put("layer0", "items/" + itemName);
        }
        else{
            this.parent = parentType.getParent() + itemName;
        }

        this.itemDisplay = itemDisplay;
        this.display = new Display(itemDisplay.getThirdperson(), itemDisplay.getFirstperson());
    }


    private static class Display{
        @Expose(serialize = true)
        private TransformData thirdperson, firstperson;

        public Display(final TransformData thirdperson, final TransformData firstperson){
            this.thirdperson = thirdperson;
            this.firstperson = firstperson;
        }
    }

    public ItemDisplay getItemDisplay() {
        return itemDisplay;
    }

    public String getParent() {
        return parent;
    }

    public Map<String, String> getTextures() {
        return textures;
    }

    public Display getDisplay() {
        return display;
    }

    public String getItemName() {
        return itemName;
    }

    public String toJson(){
        return JsonCreatorApp.serialize(this);
    }
}
