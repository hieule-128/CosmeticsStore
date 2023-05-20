package com.example.cosmeticsstore.models;

public class HomeProductModel {
    String productName;
    String productQty;
    String price;
    int productImage;

    public HomeProductModel(String productName, String productQty, String price, int productImage) {
        this.productName = productName;
        this.productQty = productQty;
        this.price = price;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductQty() {
        return productQty;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getProductImage() {
        return productImage;
    }

    public void setProductImage(int productImage) {
        this.productImage = productImage;
    }
}
