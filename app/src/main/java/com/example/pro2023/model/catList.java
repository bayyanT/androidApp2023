package com.example.pro2023.model;

public class catList {
    private String name;
    private category[]categories;

    public catList(String name, category[] categories) {
        this.name = name;
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public category[] getCategories() {
        return categories;
    }

    public void setCategories(category[] categories) {
        this.categories = categories;
    }
}
