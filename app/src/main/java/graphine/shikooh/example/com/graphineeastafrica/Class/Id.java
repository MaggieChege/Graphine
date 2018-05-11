package graphine.shikooh.example.com.graphineeastafrica.Class;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shikooh on 4/25/18.
 */

public class Id {
    @SerializedName("$oid")
    private String oid;

    public Id(String oid) {
        this.oid = oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }
}
