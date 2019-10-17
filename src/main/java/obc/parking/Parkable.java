package obc.parking;

import java.util.List;

public interface Parkable {
    public ParkingLot whichParking(Attendant attendant, List<ParkingLot> parkingLots);

}
