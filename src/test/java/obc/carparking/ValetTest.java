package obc.carparking;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValetTest {

  @Test
  public void canParkIfHasSpace() {
    var car = new Car();
    var parkingLot = new Valet(new ParkingLot(1));

    var parked = parkingLot.park(car);

    assertTrue(parked);
  }

  @Test
  public void canParkIfAtLeastOneSpaceAvailableInAtLeastOneParkingLot() {
    var car = new Car();
    var fullParkingLot = new ParkingLot(0);
    var oneSpaceParkingLot = new ParkingLot(1);
    var valet = new Valet(fullParkingLot, oneSpaceParkingLot);

    var parked = valet.park(car);

    assertTrue(parked);
  }
}