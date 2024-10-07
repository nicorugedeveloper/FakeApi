package com.api.fakeapi.model.request;

public class CreateProductLocalRequest {
    private String name;
    private int priceFinal;
    private String description;
    private int categoryId;
    private String imageUrl;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getPriceFinal() {

        return priceFinal;
    }

    public void setPriceFinal(int priceFinal) {

        this.priceFinal = priceFinal;
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
