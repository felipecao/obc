package obc.parking;

public class Car {
    private String licencePlate;
    private String size;

    public Car(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Car(String licencePlate, String size) {
        this.licencePlate = licencePlate;
        this.size = size;
    }

    public String size() {
        return size;
    }
}
