package obc.carparking;

public class ParkingLotOwner {
  private boolean isNotified;

  public boolean hasBeenNotifiedOver75() {
    return isNotified;
  }

  public void notifyOverLimit() {
    this.isNotified = true;
  }

  public void notifyBellowLimit() {
    this.isNotified = true;
  }

  public boolean hasBeenNotifiedBellow20() {
    return isNotified;
  }

  public void resetNotifications() {
    isNotified = false;
  }
}
