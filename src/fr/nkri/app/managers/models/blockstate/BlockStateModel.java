package fr.nkri.app.managers.models.blockstate;

import com.google.gson.annotations.Expose;
import fr.nkri.app.JsonCreatorMain;
import java.util.HashMap;
import java.util.Map;

public class BlockStateModel {

    @Expose(serialize = false)
    private String blockStateName;
    @Expose(serialize = true)
    private Map<String, Model> variants;

    public BlockStateModel(final String blockStateName){
        final Model model = new Model(blockStateName);
        this.variants = new HashMap<>();

        variants.put("normal", model);
    }

    private class Model{
        @Expose(serialize = true)
        private String model;

        public Model(final String modelName){
            this.model = modelName;
        }

        public String getModelName() {
            return model;
        }
    }

    public String toJson(){
        return JsonCreatorMain.serialize(this);
    }
}
