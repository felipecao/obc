package obc.parking;

import java.util.List;

public class Car {
    private final boolean requiresCertifiedDriver;
    private String licencePlate;

    public Car(String licencePlate) {
        this.licencePlate = licencePlate;
        this.requiresCertifiedDriver = false;
    }

    public Car(String plate, boolean requiresCertifiedDriver) {
        this.requiresCertifiedDriver = requiresCertifiedDriver;
    }

    public boolean doesRequireCertifiedDriver() {
        return requiresCertifiedDriver;
    }

    public ParkingLot wherePark(List<ParkingLot> parkingLots) {
        return null;
    }
}
