package fr.nkri.app.managers.models.enums;

public enum ParentType {

    BUILTIN("builtin/generated"),
    BLOCK("block/"),
    ;

    private String parent;

    private ParentType(final String parent){
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }
}
