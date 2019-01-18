package com.example.win.muzeji;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FotografijaList {
    @SerializedName("slike")
    @Expose
    private ArrayList<Fotografija> fotografije = null;
    public ArrayList<Fotografija> getFotografije(){return fotografije;}
    public void setFotografije(ArrayList<Fotografija> fotografije) {this.fotografije=fotografije;}
}
