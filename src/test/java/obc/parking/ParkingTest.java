package obc.parking;

import org.junit.Test;
import java.util.UUID;

import static java.util.stream.IntStream.range;
import static org.junit.Assert.*;

public class ParkingTest {

    private int capacity = 100;
    private ParkingLot lot = new ParkingLot(capacity);

    @Test
    public void i_want_to_park_a_car() {
        Car car = aCar();

        assertTrue(lot.park(car));
    }

    @Test
    public void parking_two_cars() {
        Car car1 = aCar();
        Car car2 = aCar();

        assertTrue(lot.park(car1));
        assertTrue(lot.park(car2));
    }

    @Test
    public void parking_two_cars_and_fetching_the_first_one() {
        Car car1 = aCar();
        Car car2 = aCar();

        assertTrue(lot.park(car1));
        assertTrue(lot.park(car2));

        assertTrue(lot.fetch(car1));
    }

    @Test
    public void fetching_an_unparked_car() {
        Car car = aCar();

        assertFalse(lot.fetch(car));
    }

    @Test
    public void parking_is_full() {
        ParkingLot fullParking = new ParkingLot(0);
        Car car = aCar();
        assertFalse(fullParking.park(car));
    }

    @Test
    public void attendant_parks_in_a_lot() {
        Attendant attendant = new Attendant(lot);
        Car car = aCar();
        assertTrue(attendant.park(car));
    }

    @Test
    public void attendant_parks_in_first_lot() {
        Attendant attendant = new Attendant(lot, new ParkingLot(100));
        Car car = aCar();
        assertTrue(attendant.park(car));
    }

    @Test
    public void attendant_cannot_park_in_full_lot() {
        Attendant attendant = new Attendant(new ParkingLot(0));
        Car car = aCar();
        assertFalse(attendant.park(car));
    }

    @Test
    public void attendant_cannot_park_in_first_free_lot() {
        Attendant attendant = new Attendant(new ParkingLot(0), lot);
        Car car = aCar();
        assertTrue(attendant.park(car));
    }

    @Test
    public void attendant_retrieves_car() {
        Attendant attendant = new Attendant(lot);
        Car car = aCar();

        attendant.park(car);

        assertTrue(attendant.fetch(car));
    }

    @Test
    public void attendant_cannot_retrieve_an_unparked_car() {
        Attendant attendant = new Attendant(lot);
        Car car = aCar();

        assertFalse(attendant.fetch(car));
    }

    @Test
    public void parking_rejects_car_if_more_than_80_percent_full() {
        ParkingLot lot = new ParkingLot(10);

        range(0, 8).forEach(i ->
                assertTrue(lot.park(aCar()))
        );

        assertFalse(lot.park(aCar()));
    }

    @Test
    public void parking_notifies_owner_at_75_percent_usage() {
        ParkingLot lot = new ParkingLot(10);
        ParkingLotOwner owner = new ParkingLotOwner(lot);

        lot.registerNotificationListener(owner);

        range(0, 8).forEach(i -> lot.park(aCar()));

        assertTrue(owner.hasBeenNotifiedFor("parkingLotIsOver75Percent"));
    }

    @Test
    public void parking_notifies_owner_at_20_percent_occupation() {
        ParkingLot lot = new ParkingLot(10);
        ParkingLotOwner owner = new ParkingLotOwner(lot);

        lot.registerNotificationListener(owner);

        Car car1 = aCar();
        Car car2 = aCar();
        Car car3 = aCar();

        lot.park(car1);
        lot.park(car2);
        lot.park(car3);

        lot.fetch(car3);
        lot.fetch(car2);

        assertTrue(owner.hasBeenNotifiedFor("parkingLotIsBelow20Percent"));
    }

    @Test
    public void parking_notifies_owner_at_20_percent_occupation_and_gets_closed() {
        ParkingLot lot1 = new ParkingLot(10);
        ParkingLot lot2 = new ParkingLot(10);
        ParkingLotOwner owner = new ParkingLotOwner(lot1, lot2);

        lot1.registerNotificationListener(owner);

        Car car1 = aCar();
        Car car2 = aCar();
        Car car3 = aCar();

        lot1.park(car1);
        lot1.park(car2);
        lot1.park(car3);

        lot1.fetch(car3);
        lot1.fetch(car2);

        assertTrue(owner.hasBeenNotifiedFor("parkingLotIsBelow20Percent"));
        assertFalse(lot1.isOpen());
    }

    @Test
    public void parking_not_notifies_owner_when_it_doesnt_reach_20_percent_occupation_yet() {
        ParkingLot lot = new ParkingLot(10);
        ParkingLotOwner owner = new ParkingLotOwner(lot);

        lot.registerNotificationListener(owner);

        Car car = aCar();

        lot.park(car);

        lot.fetch(car);

        assertFalse(owner.hasBeenNotifiedFor("parkingLotIsBelow20Percent"));
    }

    @Test
    public void attendant_should_park_in_least_occupied_parking_for_large_cars() {
        ParkingLot lot = new ParkingLot(2);
        ParkingLot lot2 = new ParkingLot(3);

        Attendant attendant = new Attendant(lot, lot2);

        Car car = aCar();

        attendant.park(car);

        Car aLargeCar = aLargeCar();

        attendant.park(aLargeCar);

        assertTrue(lot2.fetch(aLargeCar));

    }

    @Test
    public void attendent_should_park_in_first_handicapped_enabled_parking_for_handicapped_cars() {
        ParkingLot accessibleParking = new ParkingLot(2);
        ParkingLot badParking = new ParkingLot(3, false);

        Attendant attendant = new Attendant(accessibleParking, badParking);
        Car aHandicappedCar = aHandicappedCar();

        attendant.park(aHandicappedCar);

        assertTrue(accessibleParking.fetch(aHandicappedCar));
    }

    private Car aLargeCar() {
        return new Car(randomPlate(), CarTrait.LARGE);
    }
    private Car aHandicappedCar() {
        return new Car(randomPlate(), CarTrait.HANDICAPPED);
    }

    private Car aCar() {
        return new Car(randomPlate());
    }

    private String randomPlate() {
        return UUID.randomUUID().toString();
    }
}
