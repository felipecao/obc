package obc.carparking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValetTest {

  @Test
  public void canParkIfHasSpace() {
    Car car = new Car();
    Valet parkingLot = new Valet(new ParkingLot(1, new Owner()));

    boolean parked = parkingLot.park(car);

    assertTrue(parked);
  }

  @Test
  public void canParkIfAtLeastOneSpaceAvailableInAtLeastOneParkingLot() {
    Car car = new Car();
    ParkingLot fullParkingLot = new ParkingLot(0, new Owner());
    ParkingLot oneSpaceParkingLot = new ParkingLot(1, new Owner());
    Valet valet = new Valet(fullParkingLot, oneSpaceParkingLot);

    boolean parked = valet.park(car);

    assertTrue(parked);
  }

  @Test
  public void canOnlyParkWhen79PercentAvailability() {
    ParkingLot almostFull = new ParkingLot(100, new Owner());

    fillParkingLot(almostFull,78);

    Valet valet = new Valet(almostFull);

    Car car = new Car();
    boolean parked = valet.park(car);

    assertTrue(parked);
  }

  @Test
  public void canNotParkWhen80PercentAvailability() {
    ParkingLot fullParkingLot = new ParkingLot(10, new Owner());

    fillParkingLot(fullParkingLot,8);

    Valet valet = new Valet(fullParkingLot);

    Car car = new Car();
    boolean parked = valet.park(car);

    assertFalse(parked);
  }

  private void fillParkingLot(ParkingLot lot, int max) {
    for (int i = 0; i < max; i++) {
      lot.park(new Car());
    }
  }
}
