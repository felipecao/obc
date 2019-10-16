package obc.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private final List<Car> spaces;
  private final int totalNumberOfParkingSpots;
  private final ParkingLotOwner owner;

  public ParkingLot(int spaces) {
    totalNumberOfParkingSpots = spaces;
    this.spaces = new ArrayList<>(totalNumberOfParkingSpots);
    this.owner = new ParkingLotOwner();
  }

  public ParkingLot(ParkingLotOwner owner, int spaces) {
    totalNumberOfParkingSpots = spaces;
    this.spaces = new ArrayList<>(totalNumberOfParkingSpots);
    this.owner = owner;
  }

  public boolean park(Car c) {
    if (spaces.size() < totalNumberOfParkingSpots * 0.8) {
      if (spaces.add(c)) {
        checkAboveLimit();
        checkBellowLimit();
        return true;
      }
    }
    return false;
  }

  private void checkAboveLimit() {
    if (spaces.size() > totalNumberOfParkingSpots * 0.75) {
      owner.notifyOverLimit();
    }
  }

  private void checkBellowLimit() {
    if (spaces.size() < totalNumberOfParkingSpots * 0.2) {
      owner.notifyBellowLimit();
    }
  }

  public boolean fetch(Car car) {
    if (spaces.remove(car)) {
      checkBellowLimit();
      return true;
    }
    return false;
  }
}
