package obc.carparking;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class OwnerTest {

    @Test
    public void shouldBeNotifiedWhenPLIs75Full() {
        Owner owner = new Owner();
        ParkingLot pl = new ParkingLot(1, owner);
        pl.park(new Car());
        assertTrue(owner.hasBeenNotified());
    }

    @Test
    public void shouldBeNotifiedWhenPLIsLessThan20Full(){

    }
}
