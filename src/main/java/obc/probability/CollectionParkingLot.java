package obc.probability;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CollectionParkingLot {

    private List<ParkingLot> parkingLots;

    public CollectionParkingLot(ParkingLot... parkingLots) {
        this.parkingLots = Arrays.asList(parkingLots);
    }

    public void park(String plate1) {
        Optional<ParkingLot> freeParkingLot = parkingLots
                .stream()
                .filter(ParkingLot::isSpotAvailable)
                .findFirst();

        if (freeParkingLot.isPresent()) {
            freeParkingLot.get().takeSpot(plate1);
        }
    }

    public void unpark() {
        parkingLots.stream().findFirst().get().releaseSpot();
    }
}
