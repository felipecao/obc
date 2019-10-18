package obc.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    static class NullParkingLot extends ParkingLot {

        public NullParkingLot(int capacity, boolean isHadicappedFriendly) {
            super(capacity, isHadicappedFriendly);
        }

        @Override
        public boolean park(Car car) {
            return false;
        }
    }

    public static final ParkingLot NULL_PARKING_LOG = new NullParkingLot(0, false);
    private static final double MAX_CAPACITY = 0.8;
    private static final double NOTIFICATION_CAPACITY = 0.75;
    private static final double MIN_CAPACITY = 0.20;

    private final List<Car> parkedCars;
    private final int capacity;
    private final boolean isHadicappedFriendly;
    private ParkingLotOwner owner;
    private boolean hasGoneBeyond20PercentOccupation = false;
    private boolean open = true;
    private String name;

    public ParkingLot(final int capacity, boolean isHadicappedFriendly) {
        this.capacity = capacity;
        this.isHadicappedFriendly = isHadicappedFriendly;
        parkedCars = new ArrayList<>(capacity);
    }

    public ParkingLot(int capacity, boolean isHadicappedFriendly, String name) {
        this.capacity = capacity;
        this.isHadicappedFriendly = isHadicappedFriendly;
        this.name = name;
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

    public int occupancy() {
        return parkedCars.size();
    }

    public boolean isHandicappedFriendly() {
        return isHadicappedFriendly;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
