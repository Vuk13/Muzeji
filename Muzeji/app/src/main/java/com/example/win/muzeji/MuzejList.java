package com.example.win.muzeji;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MuzejList {
    @SerializedName("muzeji")
    //@SerializedName("employee")
    @Expose
    private ArrayList<Muzej> muzeji = null;
    public ArrayList<Muzej> getMuzeji(){
        return muzeji;
    }
    public void setMuzeji(ArrayList<Muzej> muzeji){
        this.muzeji = muzeji;
    }
}
