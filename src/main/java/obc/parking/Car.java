package obc.parking;

public class Car {
    private final CarTrait trait;
    private String licencePlate;

    public Car(String licencePlate, CarTrait size) {
        this.licencePlate = licencePlate;
        this.trait = size;
    }

    public Car(String licencePlate) {
        this.licencePlate = licencePlate;
        this.trait = CarTrait.NORMAL;
    }

    public CarTrait getTrait() {
        return this.trait;
    }
}
