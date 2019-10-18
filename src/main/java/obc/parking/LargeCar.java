package obc.parking;

import java.util.Comparator;
import java.util.List;

public class LargeCar extends Car {

    public LargeCar(String licencePlate) {
        super(licencePlate);
    }

    public ParkingLot wherePark(List<ParkingLot> parkingLots) {
        return parkingLots.stream().sorted(byOccupancy).findFirst().get();
    }

    private final Comparator<ParkingLot> byOccupancy = Comparator.comparingInt(ParkingLot::occupancy);
}
