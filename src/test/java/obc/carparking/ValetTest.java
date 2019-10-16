package obc.carparking;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValetTest {

  @Test
  public void canParkIfHasSpace() {
    Car car = new Car();
    Valet parkingLot = new Valet(new ParkingLot(1));

    boolean parked = parkingLot.park(car);

    assertTrue(parked);
  }

  @Test
  public void canParkIfAtLeastOneSpaceAvailableInAtLeastOneParkingLot() {
    Car car = new Car();
    ParkingLot fullParkingLot = new ParkingLot(3);
    ParkingLot oneSpaceParkingLot = new ParkingLot(1);
    Valet valet = new Valet(fullParkingLot, oneSpaceParkingLot);

    boolean parked = valet.park(car);

    assertTrue(parked);
  }

  @Test
  public void shouldNotParkIfParkingLotIs80PercentFull() {
    Car car1 = new Car();
    Car car2 = new Car();
    Car car3 = new Car();
    Car car4 = new Car();
    Car car5 = new Car();
    ParkingLot parkingLot = new ParkingLot(5);
    Valet valet = new Valet(parkingLot);
    valet.park(car1);
    valet.park(car2);
    valet.park(car3);
    valet.park(car4);
    boolean parked = valet.park(car5);

    assertFalse(parked);

  }
}
