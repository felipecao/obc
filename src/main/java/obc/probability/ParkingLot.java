package obc.probability;

public class ParkingLot {
    private String parkingSpot;

    public ParkingLot() {
        this.parkingSpot = null;
    }

    public boolean isSpotAvailable() {
        return this.parkingSpot == null;
    }

    public void takeSpot(String plate1) {
        if (this.parkingSpot == null) {
            this.parkingSpot = plate1;
        }
    }

    public void releaseSpot() {
        this.parkingSpot = null;
    }
}
