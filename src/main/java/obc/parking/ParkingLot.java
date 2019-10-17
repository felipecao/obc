package obc.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static final double MAX_CAPACITY = 0.8;
    private static final double NOTIFICATION_CAPACITY = 0.75;
    private static final double MIN_CAPACITY = 0.20;

    private final List<Car> parkedCars;
    private final int capacity;
    private boolean handicappedFriendly = false;
    private ParkingLotOwner owner;
    private boolean hasGoneBeyond20PercentOccupation = false;
    private boolean open = true;

    public ParkingLot(final int capacity) {
        this.capacity = capacity;
        parkedCars = new ArrayList<>(capacity);
    }

    public ParkingLot(int capacity, boolean handicappedFriendly) {
        this.handicappedFriendly = handicappedFriendly;
        this.capacity = capacity;
        parkedCars = new ArrayList<>(capacity);
    }

    public void registerNotificationListener(ParkingLotOwner owner) {
        this.owner = owner;
    }

    public boolean park(Car car) {
        if(!open) {
            return false;
        }

        if (parkedCars.size() >= MAX_CAPACITY * capacity) {
            return false;
        }

        if (parkedCars.size() >= MIN_CAPACITY * capacity) {
            hasGoneBeyond20PercentOccupation = true;
        }

        boolean isParked = parkedCars.add(car);

        notifyMaxCapacity();

        return isParked;
    }

    public double getCapacity() {
        return parkedCars.size()/(double)capacity;
    }

    private void notifyMaxCapacity() {
        if (null != owner && parkedCars.size() >= NOTIFICATION_CAPACITY * capacity) {
            owner.parkingLotIsOver75Percent();
        }
    }

    public boolean fetch(Car car) {
        boolean carFetched = parkedCars.remove(car);

        notifyMinCapacity();

        return carFetched;
    }

    private void notifyMinCapacity() {
        if(null != owner
                && parkedCars.size() < MIN_CAPACITY * capacity
                && hasGoneBeyond20PercentOccupation) {
            owner.parkingLotIsBelow20Percent(this);
        }
    }

    public boolean isOpen() {
        return open;
    }

    public void close() {
        open = false;
    }

    public boolean isHandicappedFriendly() {
        return this.handicappedFriendly;
    }
}
