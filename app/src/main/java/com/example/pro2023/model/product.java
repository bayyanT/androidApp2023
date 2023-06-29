package com.example.pro2023.model;

import com.google.gson.annotations.SerializedName;

public class product {

    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;
    @SerializedName("description")
    private String  description;
    @SerializedName("img")
    private  String imgId;

    public product(String name, String price, String description, String imgId) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }
}
