
package com.example.hong4poker.network.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Configs {

    @SerializedName("Open")
    @Expose
    private String open;
    @SerializedName("Openlink")
    @Expose
    private String openlink;

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getOpenlink() {
        return openlink;
    }

    public void setOpenlink(String openlink) {
        this.openlink = openlink;
    }

}
