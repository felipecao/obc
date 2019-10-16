package obc.probability;

public class ParkingLot {
    private int fullCapacity;
    private int capacity;
    private String parkingSpot;
    private Owner owner;

    public ParkingLot(int fullCapacity, Owner owner) {
        this.parkingSpot = null;
        this.fullCapacity = fullCapacity;
        this.capacity = fullCapacity;
        this.owner = owner;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isSpotAvailable() {
        return this.parkingSpot == null;
    }

    public void takeSpot(String plate1) {
        if (this.parkingSpot == null) {
            this.parkingSpot = plate1;
            if(capacity/fullCapacity > 0.75){
                owner.notifyMeParkingOverused(this);
            }
            if(capacity/fullCapacity < 0.20){
                owner.notifyMeParkingUnderused(this);
            }
        }
    }

    public void releaseSpot() {
        this.parkingSpot = null;
        if(capacity/fullCapacity < 0.20){
            owner.notifyMeParkingUnderused(this);
        }
    }

    public int getFullCapacity() {
        return fullCapacity;
    }
}
