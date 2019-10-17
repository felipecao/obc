package obc.parking;

public class NullParkingLot extends ParkingLot {

    public NullParkingLot(int capacity) {
        super(capacity);
    }

    @Override
    public boolean park(Car car) {
        return false;
    }
}
