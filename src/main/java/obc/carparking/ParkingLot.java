package obc.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private final List<Car> spaces;
  private final int totalNumberOfParkingSpots;
  private final Owner owner;

  public ParkingLot(int spaces, Owner owner) {
    totalNumberOfParkingSpots = spaces;
    this.owner = owner;
    this.spaces = new ArrayList<>(totalNumberOfParkingSpots);
  }

  public boolean park(Car c) {
    if (spaces.size() < totalNumberOfParkingSpots * 0.8) {
      boolean result = spaces.add(c);
      if (spaces.size() > totalNumberOfParkingSpots * 0.75) {
        owner.notifyParkingFull();
      }
      return result;
    }
    return false;
  }

  public boolean fetch(Car car) {
    return spaces.remove(car);
  }
}
