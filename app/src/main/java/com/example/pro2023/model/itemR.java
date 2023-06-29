package com.example.pro2023.model;


public class itemR {
    private String name;
    private int imgId;
    private  String price;

    public itemR(String name, int imgId, String price) {
        this.name = name;
        this.imgId = imgId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
