package com.example.cosmeticsstore.models;

public class HomeHorModel {
    String image, name;

    public HomeHorModel(){

    }
    public HomeHorModel(String image, String name) {
        this.image = image;
        this.name = name;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
