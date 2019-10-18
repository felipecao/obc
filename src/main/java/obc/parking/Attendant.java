package obc.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Attendant {
    private final boolean certified;
    private List<ParkingLot> parkingLots;
    private List<Attendant> myHiredAttendants = new ArrayList<>();
    private String name;
    private ParkingLotOwner owner;

    public Attendant(List<ParkingLot> parkingLots, String name) {
        this.parkingLots = parkingLots;
        this.name = name;
        this.certified = false;
    }

    public Attendant(ParkingLot... lots) {
        this.parkingLots = new ArrayList<>(Arrays.asList(lots));
        this.certified = false;
    }

    public Attendant(ParkingLot emptyLot, boolean certified) {
        this.parkingLots = Arrays.asList(emptyLot);
        this.certified = certified;
    }

    public boolean park(Car car) {
        if (car.doesRequireCertifiedDriver() && !certified) {
            return false;
        }

        if (car instanceof LargeCar || car instanceof HandicappedCar) {
            return car.wherePark(parkingLots).park(car);
        }

        return parkingLots
                .stream()
                .anyMatch(lot -> lot.park(car));
    }


    public boolean fetch(Car car) {
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.fetch(car));
    }

    public boolean isCertified() {
        return certified;
    }

    public boolean hire(Attendant hiredAttendant) {
        if (parkingLots.size() > 1) {
            myHiredAttendants.add(hiredAttendant);
            hiredAttendant.assign(parkingLots.stream().findFirst().get());
            return true;
        }
        return false;
    }

    private void assign(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        owner.notifyAttendantAndParkingLot();
    }

    public void registerNotificationListener(ParkingLotOwner owner) {
        this.owner = owner;
    }
}