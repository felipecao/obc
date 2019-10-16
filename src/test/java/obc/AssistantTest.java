package obc;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class AssistantTest {
    @Test
    public void testThatAssistantCanPark() {
        Assistant assistant = new Assistant();
        Car car = new Car();
        ParkingLot pl = new ParkingLot(1);

        assistant.park(car, pl);

        assertTrue(car.isParked());
    }

    @Test
    public void testThatAssistantCanRetrieve() {
        Assistant assistant = new Assistant();
        Car car = new Car();
        ParkingLot pl = new ParkingLot(1);
        ParkingLot pl2 = new ParkingLot(1);


        assistant.park(car, pl);
        assistant.retrieve(car, pl);
        assistant.retrieve(car, pl2);


        assertFalse(car.isParked());
    }
}
