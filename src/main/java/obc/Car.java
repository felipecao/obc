package obc;

public class Car {

    private boolean parked;

    public void park(ParkingLot parkingLot) {
        parkingLot.takeSpace();
        this.parked = true;
    }

    public boolean isParked() {
        return this.parked;
    }

    public void unPark(ParkingLot parkingLot) {
        parkingLot.releaseSpace();
        this.parked = false;
    }
}
