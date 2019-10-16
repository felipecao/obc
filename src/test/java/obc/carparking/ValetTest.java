package obc.carparking;

import static org.junit.Assert.assertFalse;
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

  @Test
  public void canOnlyParkWhen79PercentAvailability() {
    var almostFull = new ParkingLot(100);

    fillParkingLot(almostFull,78);

    var valet = new Valet(almostFull);

    var car = new Car();
    var parked = valet.park(car);

    assertTrue(parked);
  }

  @Test
  public void canNotParkWhen80PercentAvailability() {
    var fullParkingLot = new ParkingLot(10);

    fillParkingLot(fullParkingLot,8);

    var valet = new Valet(fullParkingLot);

    var car = new Car();
    var parked = valet.park(car);

    assertFalse(parked);
  }

  private void fillParkingLot(ParkingLot lot, int max) {
    for (int i = 0; i < max; i++) {
      lot.park(new Car());
    }
  }
}