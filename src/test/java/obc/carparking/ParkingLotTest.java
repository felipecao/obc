package obc.carparking;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ParkingLotTest {

  @Test
  public void canParkIfHasSpace() {
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(1, new Owner());

    boolean parked = parkingLot.park(car);

    assertTrue(parked);
  }

  @Test
  public void canNotParkIfFull() {
    Car car1 = new Car();
    ParkingLot parkingLot = new ParkingLot(1, new Owner());

    parkingLot.park(car1);

    Car car2 = new Car();
    boolean couldPark = parkingLot.park(car2);

    assertFalse(couldPark);
  }

  @Test
  public void canLeaveParking() {
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(1, new Owner());
    parkingLot.park(car);

    boolean removed = parkingLot.fetch(car);

    assertThat(removed, is(true));
  }

  @Test
  public void canNotRetrieveNonExistentCar() {
    Car car = new Car();
    ParkingLot parkingLot = new ParkingLot(1, new Owner());

    boolean removed = parkingLot.fetch(car);

    assertThat(removed, is(false));
  }

//  @Test
//  public void notifyEveryTimeIm75PercentFull() {
//    ParkingLot parkingLot = new ParkingLot(1, new Owner());
//    Car car = new Car();
//    boolean couldPark = parkingLot.park(car);
//
//    assertThat(, is(false));
//  }

}
