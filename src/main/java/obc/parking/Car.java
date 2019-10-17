package obc.parking;

import obc.parking.ParkingStrategies.Handicap;

import java.util.List;

public class Car {
    private final CarTrait trait;
    private Parkable strategy;
    private String licencePlate;

    public Car(String licencePlate, CarTrait size, Parkable strategy) {
        this.licencePlate = licencePlate;
        this.trait = size;
        this.strategy = strategy;
    }

    public Car(String licencePlate, CarTrait trait) {
        this.trait = trait;
        this.licencePlate = licencePlate;
        this.strategy = new Handicap();
    }

    public Car(String licencePlate) {
        this.licencePlate = licencePlate;
        this.trait = CarTrait.NORMAL;
        this.strategy = new Handicap();
    }

    public CarTrait getTrait() {
        return this.trait;
    }

    public ParkingLot whichParkingLot(Attendant attendant, List<ParkingLot> parkingLots) {
        return this.strategy.whichParking(attendant, parkingLots);
    }
}
