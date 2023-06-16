package com.example.cosmeticsstore.models;

public class CategoryModel {
    int catImage;
    String catText;
    String productNum;

    public CategoryModel(int catImage, String catText, String productNum) {
        this.catImage = catImage;
        this.catText = catText;
        this.productNum = productNum;
    }


    public int getCatImage() {
        return catImage;
    }

    public void setCatImage(int catImage) {
        this.catImage = catImage;
    }

    public String getCatText() {
        return catText;
    }

    public void setCatText(String catText) {
        this.catText = catText;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }
}
