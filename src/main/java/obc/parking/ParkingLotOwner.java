package obc.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParkingLotOwner {

    private List<ParkingLot> parkingLots;
    private List<String> notifications;

    public ParkingLotOwner(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
        this.notifications = new ArrayList<>();
    }

    public void parkingLotIsOver75Percent() {
        notifications.add("parkingLotIsOver75Percent");
    }

    public void parkingLotIsBelow20Percent(ParkingLot parkingLot) {
        notifications.add("parkingLotIsBelow20Percent");
        boolean isAtLeastOneOpen = parkingLots.stream().filter(lot -> lot.isOpen()).count() > 1;

        if(isAtLeastOneOpen) {
            parkingLot.close();
        }
    }

    public boolean hasBeenNotifiedFor(String message) {
        return notifications.contains(message);
    }
}
