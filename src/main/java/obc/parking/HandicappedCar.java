package obc.parking;

import java.util.List;

public class HandicappedCar extends Car {
    public HandicappedCar(String licencePlate) {
        super(licencePlate);
    }

    public ParkingLot wherePark(List<ParkingLot> parkingLots) {
        return parkingLots
                .stream()
                .filter(ParkingLot::isHandicappedFriendly)
                .findFirst()
                .orElse(ParkingLot.NULL_PARKING_LOG);
    }
}
