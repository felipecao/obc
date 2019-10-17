package obc.parking;

import org.junit.Test;

import java.util.List;
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
        Assistant assistant = new Assistant(lot);
        Car car = aCar();
        assertTrue(assistant.park(car));
    }

    @Test
    public void attendant_parks_in_first_lot() {
        Assistant assistant = new Assistant(lot, new ParkingLot(100));
        Car car = aCar();
        assertTrue(assistant.park(car));
    }

    @Test
    public void attendant_cannot_park_in_full_lot() {
        Assistant assistant = new Assistant(new ParkingLot(0));
        Car car = aCar();
        assertFalse(assistant.park(car));
    }

    @Test
    public void attendant_cannot_park_in_first_free_lot() {
        Assistant assistant = new Assistant(new ParkingLot(0), lot);
        Car car = aCar();
        assertTrue(assistant.park(car));
    }

    @Test
    public void attendant_retrieves_car() {
        Assistant assistant = new Assistant(lot);
        Car car = aCar();

        assistant.park(car);

        assertTrue(assistant.fetch(car));
    }

    @Test
    public void attendant_cannot_retrieve_an_unparked_car() {
        Assistant assistant = new Assistant(lot);
        Car car = aCar();

        assertFalse(assistant.fetch(car));
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
    public void assistantParksLargeCarsInTheEmptiestParkingLot() {
        ParkingLot fullerLot = new ParkingLot(10);
        ParkingLot emptierLot = new ParkingLot(10);

        Assistant assistant = new Assistant(fullerLot, emptierLot);

        fullerLot.park(aCar());

        Car car = Car.largeCar(randomPlate());

        assistant.park(car);

        assertTrue(emptierLot.fetch(car));
    }

    @Test
    public void assistantParksHandicapedCarsInTheFirstParkingLotThatAcceptsThem() {
        ParkingLot lot = new ParkingLot(10);
        ParkingLot handicapedFriendlylot = new ParkingLot(10, true);

        Assistant assistant = new Assistant(lot, handicapedFriendlylot);

        Car car = Car.handicapedCar(randomPlate());

        assistant.park(car);

        assertTrue(handicapedFriendlylot.fetch(car));
    }

    @Test
    public void assistantCanNotParkFancyCarsIfNotCertified() {
        ParkingLot lot = new ParkingLot(10);
        Assistant assistant = new Assistant(lot);

        Car car = Car.fancyCar(randomPlate());
        assertFalse(assistant.park(car));

    }


    @Test
    public void assistantCanParkFancyCarsOnlyIfCertified() {
        ParkingLot lot = new ParkingLot(10);
        Assistant assistant = new Assistant(lot);
        assistant.certify();

        Car car = Car.fancyCar(randomPlate());
        assertTrue(assistant.park(car));

    }

    @Test
    public void assistantsCanHireAssistantsToTakeCareOfTheirParkingLots() {
        ParkingLot lot1 = new ParkingLot(10);
        ParkingLot lot2 = new ParkingLot(10);
        ParkingLot lot3 = new ParkingLot(10);

        Assistant fatherAssistant = new Assistant(lot1,lot2,lot3);

        Assistant childAssistant = fatherAssistant.hireAssistant(lot1);
        assertEquals(fatherAssistant.hiredAssistants(), List.of(childAssistant));

        Car car = aCar();
        fatherAssistant.park(car);
        assertEquals(0, lot1.getCapacity(), 0.01);
        assertEquals(0.1, lot2.getCapacity(), 0.01);

    }

    private Car aCar() {
        return new Car(randomPlate());
    }

    private String randomPlate() {
        return UUID.randomUUID().toString();
    }
}
