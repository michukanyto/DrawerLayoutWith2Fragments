package model;

import java.io.Serializable;

public class Vehicule implements Serializable {
    private String brand;
    private float price;
    private String pictureId;


    public Vehicule(String brand, float price, String pictureId) {
        this.brand = brand;
        this.price = price;
        this.pictureId = pictureId;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public String toString() {
        return  brand;
    }
}
