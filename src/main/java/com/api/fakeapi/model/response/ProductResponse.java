package com.api.fakeapi.model.response;

public class ProductResponse {

    private int pid;
    private String name;
    private double priceFinal;
    private String description;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {

        this.pid = pid;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public double getPriceFinal() {

        return priceFinal;
    }

    public void setPriceFinal(double priceFinal) {

        this.priceFinal = priceFinal;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

}


