package obc.probability;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ParkingAssistantTest {


    @Test
    public void shouldPlaceACarInTheParkingLot(){
        ParkingLot pl = new ParkingLot(10, new Owner () );
        ParkingAssistant pa = new ParkingAssistant(pl);
        pa.parkCar("plate1");
        assertFalse(pl.isSpotAvailable());
    }

    @Test
    public void shouldRetrieveACarFromTheParkingLot(){
        ParkingLot pl = new ParkingLot(10, new Owner ());
        ParkingAssistant pa = new ParkingAssistant(pl);
        pa.parkCar("plate1");
        pa.retrieveCar();
        assertTrue(pl.isSpotAvailable());
    }

    @Test
    public void shouldParkACarInAFreeParkingLotSpot() {
        ParkingLot pl1 = new ParkingLot(10, new Owner ());
        ParkingLot pl2 = new ParkingLot(10, new Owner ());
        ParkingLot pl3 = new ParkingLot(10, new Owner ());

        ParkingAssistant pa = new ParkingAssistant (pl1, pl2, pl3);

        pa.parkCar("plate1");

        // FIXME this test is not fully done yet
        // TODO have a full parking lot and make sure the assistant has parked on the one that
        //      wasn't full
    }

    @Test
    public void shouldParkACarInAFreeParkingLotSpotWith80perCentFree() {
        ParkingLot pl1 = new ParkingLot(10, new Owner ());

        ParkingAssistant pa = new ParkingAssistant (pl1);

        for(int i = 0; i < 8; i++){pa.parkCar(String.format("i=%s", i));}

       // assertFalse(pa.parkCar("plate1"));

        // FIXME this test is not fully done yet
        // TODO have a full parking lot and make sure the assistant has parked on the one that
        //      wasn't full
    }
}