package model;

public class Bike extends Vehicule {

    private String bikeType;

    public Bike(String brand, float price, String pictureId, String bikeType) {
        super(brand, price, pictureId);
        this.bikeType = bikeType;
    }

    public String getBikeType() {
        return bikeType;
    }

    public void setBikeType(String bikeType) {
        this.bikeType = bikeType;
    }
}
