package obc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParkingSpaceTest {

    @Test
    public void shouldParkACarWhenTheSpaceIsAvailable() {
        ParkingSpace space = new ParkingSpace();
        String car = "license1";
        boolean result = space.park(car);
        assertEquals(car, space.getParkedCar());
    }

    @Test
    public void shouldNotParkACarWhenTheSpaceIsOccupied() {
        ParkingSpace space = new ParkingSpace();
        String car1 = "license1";
        String car2 = "license2";
        space.park(car1);
        boolean result = space.park(car2);

        assertEquals(result, false);
        assertEquals(car1, space.getParkedCar());
    }

    @Test
    public void shouldRetrieveTheCarWhenTheSpaceIsOccupied() {
        ParkingSpace space = new ParkingSpace();
        Car car1 = new Car("license1");
        space.park(car1);

        String retrievedCart = space.retrieve(car1);

        assertEquals(null, space.getParkedCar());
        assertEquals(car1, retrievedCart);
    }

    @Test
    public void shouldNotRetrieveTheCarWhenItHasNotBeenParked() {
        ParkingSpace space = new ParkingSpace();
        String car1 = "license1";

        String retrievedCar = space.retrieve(car1);

        assertEquals(null, space.getParkedCar());
        assertEquals(null, retrievedCar);
    }

    @Test
    public void shouldNotRetrieveTheCarWhenItHasNotBeenParkedAndTheSpaceIsOccupied() {
        ParkingSpace space = new ParkingSpace();
        String car1 = "license1";
        String car2= "license2";
        space.park(car1);

        String retrievedCar = space.retrieve(car2);

        assertEquals(car1, space.getParkedCar());
        assertEquals(null, retrievedCar);
    }
}