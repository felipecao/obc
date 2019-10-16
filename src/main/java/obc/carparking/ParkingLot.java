package obc.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private final List<Car> spaces;
  private final int totalNumberOfParkingSpots;

  public ParkingLot(int spaces) {
    totalNumberOfParkingSpots = spaces;
    this.spaces = new ArrayList<>(totalNumberOfParkingSpots);
  }

  public boolean park(Car c) {
    if (spaces.size() < totalNumberOfParkingSpots * 0.8) {
      return spaces.add(c);
    }
    return false;
  }

  public boolean fetch(Car car) {
    return spaces.remove(car);
  }
}
