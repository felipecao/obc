package obc.parking;

import org.junit.Test;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.Assert.*;

public class ParkingLotOwnerTest {

    @Test
    public void should_report_parking_lot_occupancy() {
        ParkingLot parkingLot = new ParkingLot(10, false);
        ParkingLotOwner parkingLotOwner = new ParkingLotOwner(parkingLot);
        Car aCar = aCar();
        parkingLot.park(aCar);

        assertEquals(parkingLotOwner.reportOccupancyOfParkingLot(parkingLot).get(0), new HashMap<Integer,Integer>(1, 10).get(0));
    }

    private Car aCar() {
        return new Car(randomPlate());
    }

    private String randomPlate() {
        return UUID.randomUUID().toString();
    }

}