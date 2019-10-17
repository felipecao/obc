package obc.parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class Assistant {
    private final ArrayList<Assistant> hiredAssistants;
    private List<ParkingLot> parkingLots;
    private boolean certified = false;

    public Assistant(ParkingLot... lots) {
        this.parkingLots = new LinkedList<>();
        parkingLots.addAll(Arrays.asList(lots));
        this.hiredAssistants = new ArrayList<>();
    }

    public boolean park(Car car) {
        if(car.isFancy() && !certified) {
            return false;
        }
        Stream<ParkingLot> lots = car.parkingLotStrategy(parkingLots);
        return lots.anyMatch(lot -> lot.park(car));
    }

    public boolean fetch(Car car) {
        return parkingLots
                .stream()
                .anyMatch(lot -> lot.fetch(car));
    }

    public void certify() {
        this.certified = true;
    }

    public Assistant hireAssistant(ParkingLot lot1) {
        Assistant hired = new Assistant(lot1);
        hiredAssistants.add(hired);
        this.parkingLots.remove(lot1);
        return hired;
    }

    public ArrayList<Assistant> hiredAssistants() {
        return hiredAssistants;
    }
}