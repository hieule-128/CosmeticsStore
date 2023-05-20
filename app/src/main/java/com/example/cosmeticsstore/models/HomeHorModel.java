package com.example.cosmeticsstore.models;

public class HomeHorModel {
    int image;
    String text;

    public HomeHorModel(int image, String name) {
        this.image = image;
        this.text = name;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return text;
    }
    public void setName(String name) {
        this.text = name;
    }
}
