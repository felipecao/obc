package obc.carparking;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class ParkingLotTest {

  @Test
  public void canParkIfHasSpace() {
    var car = new Car();
    var parkingLot = new ParkingLot(1);

    var parked = parkingLot.park(car);

    assertTrue(parked);
  }

  @Test
  public void canNotParkIfFull() {
    var car1 = new Car();
    var parkingLot = new ParkingLot(1);

    parkingLot.park(car1);

    var car2 = new Car();
    var couldPark = parkingLot.park(car2);

    assertFalse(couldPark);
  }

  @Test
  public void canLeaveParking() {
    var car = new Car();
    var parkingLot = new ParkingLot(1);
    parkingLot.park(car);

    var removed = parkingLot.fetch(car);

    assertThat(removed, is(true));
  }

  @Test
  public void canNotRetrieveNonExistentCar() {
    var car = new Car();
    var parkingLot = new ParkingLot(1);

    var removed = parkingLot.fetch(car);

    assertThat(removed, is(false));
  }

  @Test
  public void notifiesWhenSeventyFiveFull() {
    var parkingLot = new ParkingLot(100);
    var vale = mock(Valet.class);
    parkingLot.subscribe(vale);

    fillParkingLot(parkingLot, 76);r
    verify(vale, atLeast(1)).notifyCapacity();

  }

  @Test
  public void notifiesWhenLowCapacityInAParking() {
    var parkingLot = new ParkingLot(100);
    var vale = mock(Valet.class);
    parkingLot.subscribe(vale);

    fillParkingLot(parkingLot, 15);

    verify(vale, atLeast(1)).notifyCapacity();

  }


  private void fillParkingLot(ParkingLot lot, int max) {
    for (int i = 0; i < max; i++) {
      lot.park(new Car());
    }
  }

}