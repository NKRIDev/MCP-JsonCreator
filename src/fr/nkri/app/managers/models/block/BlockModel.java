package fr.nkri.app.managers.models.block;

import com.google.gson.annotations.Expose;
import fr.nkri.app.JsonCreatorApp;

public class BlockModel {

    @Expose(serialize = false)
    private String blockName;
    @Expose(serialize = true)
    private String parent;
    @Expose(serialize = true)
    private Textures textures;

    public BlockModel(final String blockName){
        this.blockName = blockName;
        this.parent = "block/cube_all";
        this.textures = new Textures(blockName);
    }

    private class Textures{
        @Expose(serialize = true)
        private String all;

        public Textures(final String blockName){
            this.all = "blocks/" + blockName;
        }

        public String getAll() {
            return all;
        }
    }

    public String toJson(){
        return JsonCreatorApp.serialize(this);
    }
}
