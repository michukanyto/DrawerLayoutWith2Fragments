package model;

public class Car extends Vehicule {

    private String model;
    private  int year;

    public Car(String brand, float price, String pictureId, String model, int year) {
        super(brand, price, pictureId);
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
