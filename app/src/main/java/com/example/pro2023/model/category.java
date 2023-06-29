package com.example.pro2023.model;

import com.google.gson.annotations.SerializedName;

public class category {
    @SerializedName("img")
    private String imgId;
    @SerializedName("name")
    private String nameCategory;


    public category(String imgId, String nameCategory) {
        this.imgId = imgId;
        this.nameCategory = nameCategory;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }


}
