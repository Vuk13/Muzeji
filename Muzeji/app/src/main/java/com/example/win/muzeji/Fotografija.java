package com.example.win.muzeji;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fotografija {
    @SerializedName("id_img")
    @Expose
    private Integer id_img;
    @SerializedName("muzej_id")
    @Expose
    private Integer muzej_id;
    @SerializedName("image_url")
    @Expose
    private String image_url;

    public Integer getId_img() {
        return id_img;
    }

    public void setId_img(Integer id_img) {
        this.id_img = id_img;
    }

    public Integer getMuzej_id() {
        return muzej_id;
    }

    public void setMuzej_id(Integer muzej_id) {
        this.muzej_id = muzej_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
