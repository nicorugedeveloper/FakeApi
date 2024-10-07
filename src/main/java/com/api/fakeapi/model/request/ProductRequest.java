package com.api.fakeapi.model.request;

public class ProductRequest {
    private String name;
    private double price;
    private String description;
    private int categoryId;
    private String imageUrl;

    public ProductRequest(String name, double price, String description, int categoryId, String imageUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
