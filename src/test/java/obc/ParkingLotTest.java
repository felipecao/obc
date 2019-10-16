package obc;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingLotTest {
    @Test
    public void testReceiveCar()  {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        car.park(parkingLot);

        assertTrue(parkingLot.isFull());
    }

    public void testReleaseCar()  {
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot(1);
        car.park(parkingLot);
        car.unPark(parkingLot);

        assertFalse(parkingLot.isFull());
    }

    public void testFullParkingLot()  {
        Car car = new Car();
        Car anotherCar = new Car();

        ParkingLot parkingLot = new ParkingLot(1);
        car.park(parkingLot);
        anotherCar.park(parkingLot);

        assertFalse(anotherCar.isParked());
    }
}
