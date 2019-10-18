package obc.parking;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AttendantTest {
    @Test
    public void cannot_hire_an_attendant_with_only_one_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(1, true);
        Attendant attendant = new Attendant(parkingLot);
        Attendant hiredAttendant = new Attendant();

        attendant.hire(hiredAttendant);
        assertFalse(attendant.hire(hiredAttendant));
    }

    @Test
    public void can_hire_an_attendant() {
        ParkingLot parkingLot = new ParkingLot(1, true);
        ParkingLot secondParkingLot = new ParkingLot(2, true);

        Attendant attendant = new Attendant(parkingLot, secondParkingLot);
        Attendant hiredAttendant = new Attendant();
        assertTrue(attendant.hire(hiredAttendant));

        attendant.park(new Car(""));
        assertThat(parkingLot.occupancy(), is(1));
    }

    @Test
    public void attendant_will_delegate_if_unable_to_park() {
        ParkingLot parkingLot = new ParkingLot(1, true);
        ParkingLot secondParkingLot = new ParkingLot(2, false);

        Attendant attendant = new Attendant(parkingLot, secondParkingLot);
        Attendant hiredAttendant = new Attendant();
        attendant.hire(hiredAttendant);

        attendant.park(new HandicappedCar(""));
        assertThat(parkingLot.occupancy(), is(1));
    }
}