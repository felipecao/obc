package obc.parking.ParkingStrategies;

import obc.parking.Attendant;
import obc.parking.NullParkingLot;
import obc.parking.Parkable;
import obc.parking.ParkingLot;

import java.util.List;

public class Handicap implements Parkable {

    @Override
    public ParkingLot whichParking(Attendant attendant, List<ParkingLot> parkingLots) {
        return parkingLots.stream().filter(ParkingLot::isHandicappedEnabled).findFirst().orElse(new NullParkingLot(0));
    }
}
