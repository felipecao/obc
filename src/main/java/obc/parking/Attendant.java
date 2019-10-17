package obc.parking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Attendant {
    private List<ParkingLot> parkingLots;
    private boolean certificate = false;
    private Attendant subAttendant = null;

    public void setCertificate(boolean certificate) {
        this.certificate = certificate;
    }

    public Attendant(ParkingLot... lots) {

        this.parkingLots = new LinkedList<>(Arrays.asList(lots));
        if (parkingLots.size() > 1) {
            this.subAttendant = new Attendant(parkingLots.remove(0));
        }
    }

    public boolean park(Car car) {
        boolean result = false;
        switch (car.getTrait()) {
            case NORMAL:
                result = parkingLots
                        .stream()
                        .anyMatch(lot -> lot.park(car));
                break;
            case LARGE:

                // FIXME
                parkingLots.stream().sorted().findFirst();
                break;
            case HANDICAPPED:
                ParkingLot parkingLot = car.whichParkingLot(this, parkingLots);
                if (!parkingLot.park(car)) {
                    result = this.subAttendant.park(car);
                }
                ;
                break;
            case LUXURY:
                if (this.certificate) {
                    result = true;
                }
                break;
        }
        return result;
    }

    public boolean fetch(Car car) {
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.fetch(car));
    }
}