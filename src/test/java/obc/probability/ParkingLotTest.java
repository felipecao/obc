package obc.probability;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParkingLotTest {

    @Test
    public void shouldHaveAnEmptySpaceAvailable_WhenCreated() {

        assertTrue(new ParkingLot(10, new Owner()).isSpotAvailable());
    }

    @Test
    public void shouldPlaceACarToTheParkingLot() {
        ParkingLot pl = new ParkingLot(10, new Owner());
        pl.takeSpot("plate1");

        assertFalse(pl.isSpotAvailable());
    }

    @Test
    public void shouldRetrieveACarFromTheParkingLot() {
        ParkingLot pl = new ParkingLot(10, new Owner());
        pl.releaseSpot();

        assertTrue(pl.isSpotAvailable());
    }

    @Test
    public void shouldNotifyWhenCapacityIsOver75Percent() {
        Owner owner = new Owner();
        ParkingLot pl = new ParkingLot(10, owner);
        pl.takeSpot("plate1");
        pl.takeSpot("plate2");
        pl.takeSpot("plate3");
        pl.takeSpot("plate4");
        pl.takeSpot("plate5");
        pl.takeSpot("plate6");
        pl.takeSpot("plate7");
        pl.takeSpot("plate8");

        assertTrue(owner.notifyMeParkingOverused(pl));


        //assert call to notification service
    }

}