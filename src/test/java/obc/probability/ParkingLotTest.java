package obc.probability;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class ParkingLotTest {

    @Test public void shouldHaveAnEmptySpaceAvailable_WhenCreated(){

        assertTrue(new ParkingLot().isSpotAvailable());
    }

    @Test public void shouldPlaceACarToTheParkingLot(){
        ParkingLot pl = new ParkingLot();
        pl.takeSpot("plate1");

        assertFalse(pl.isSpotAvailable());
    }

    @Test public void shouldRetrieveACarFromTheParkingLot(){
        ParkingLot pl = new ParkingLot();
        pl.releaseSpot();

        assertTrue(pl.isSpotAvailable());
    }

}