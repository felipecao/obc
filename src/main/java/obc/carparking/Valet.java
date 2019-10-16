package obc.carparking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Valet {

  private final List<ParkingLot> lots = new ArrayList<>();

  public Valet(ParkingLot ...lots) {
    Collections.addAll(this.lots, lots);
  }

  public boolean park(Car c) {
    for (var lot: lots) {
      if (lot.park(c)) {
        return true;
      }
    }
    return false;
  }

  public void notifySeventyFivePercentUsage() {

  }

  public void notifyLowCapacityUsage() {
  }

  public void notifyCapacity() {

  }
}
