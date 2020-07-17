package entities;

import java.util.ArrayList;

public class ObjectPrivilege {
    private String privName;
    private String desc;
    private boolean colLevel;
    private boolean grantOpt;

    public ObjectPrivilege(String name, String desc, boolean colLevel) {
        this.privName = name;
        this.desc = desc;
        this.colLevel = colLevel;
    }

    public String getPrivName() {
        return privName;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isColLevel() {
        return colLevel;
    }
}
