package obc.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private final List<Car> spaces;
  private final int totalNumberOfParkingSpots;

  private List<Valet> subscribers;

  public ParkingLot(int spaces) {
    totalNumberOfParkingSpots = spaces;
    this.spaces = new ArrayList<>(totalNumberOfParkingSpots);
    subscribers = new ArrayList<>();
  }

  public boolean park(Car c) {
    if (spaces.size() < totalNumberOfParkingSpots * 0.8) {
      if (spaces.size() >= totalNumberOfParkingSpots * 0.75) {
        notifySubscribers();
      }
      if (spaces.size() <= totalNumberOfParkingSpots * 0.20) {
        notifySubscribers();
      }
      return spaces.add(c);
    }
    return false;
  }

  private void notifySubscribers() {
    for (Valet v : subscribers) {
      v.notifyCapacity();
    }
  }

  public boolean fetch(Car car) {
    return spaces.remove(car);
  }

  public void subscribe(Valet valet) {
    subscribers.add(valet);
  }
}
