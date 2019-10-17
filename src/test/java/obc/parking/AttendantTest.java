package obc.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AttendantTest {
    @Test
    public void i_can_park_a_large_car() {
        ParkingLot freeLot = new ParkingLot(1);
        ParkingLot busyLot = new ParkingLot(2);
        Car mediumCar = new Car("", "MEDIUM");

        Attendant attendant = new Attendant(busyLot, freeLot);
        assertThat(attendant.park(mediumCar), is(true));

        Car largeCar = new Car("", "LARGE");

        assertThat(attendant.park(largeCar), is(true));

        assertThat(busyLot.occupancy(), is(50));
        assertThat(freeLot.occupancy(), is(100));
    }
}