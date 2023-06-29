package com.example.pro2023.model;

import com.google.gson.annotations.SerializedName;

public class doctors {
    @SerializedName("name")
  private String name;
    @SerializedName("email")
  private String email;
    @SerializedName("password")
  private  String password;
    @SerializedName("phone")
  private  String phone;
    @SerializedName("img")
  private  String  imgId;

    public doctors(String name, String email, String password, String phone, String imgId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.imgId = imgId;
    }

    public String getImgId() {
        return imgId;
    }

    public void setImgId(String imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
