package obc;

public class ParkingLot {
    private final int capacity;
    private int freeSpaces;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        this.freeSpaces = capacity;
    }

    public boolean isFull() {
        return this.freeSpaces == 0;
    }

    public boolean takeSpace() {
        if (isFull()) {
            return false;
        }
        this.freeSpaces -= 1;
        return true;
    }


    public void releaseSpace() {
        this.freeSpaces += 1;
    }
}
