package obc.carparking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

  private final List<Car> spaces;
  private final int spacesAvailable;

  public ParkingLot(int s) {
    spacesAvailable = s;
    spaces = new ArrayList<>(spacesAvailable);
  }

  public boolean park(Car c) {
    if (spaces.size() < spacesAvailable) {
      return spaces.add(c);
    }
    return false;
  }

  public boolean isLessThan80PercentFull(){
    return (spaces.size()/spacesAvailable <= 0.8);
  }


  public boolean fetch(Car car) {
    return spaces.remove(car);
  }
}
