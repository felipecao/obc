package obc.parking;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Car {
    private String licencePlate;
    private boolean isLarge = false;
    private boolean isHandicapped = false;
    private boolean isFancy = false;

    public Car(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public static Car largeCar(String licencePlate){
        Car largeCar = new Car(licencePlate);
        largeCar.isLarge = true;
        return largeCar;
    }

    public static Car handicapedCar(String licencePlate) {
        Car handicappedCar = new Car(licencePlate);
        handicappedCar.isHandicapped = true;
        return handicappedCar;
    }

    public static Car fancyCar(String licencePlate) {
        Car fancyCar = new Car(licencePlate);
        fancyCar.isFancy = true;
        return fancyCar;
    }

    public boolean isLarge() {
        return isLarge;
    }

    public boolean isHandicapped() {
        return isHandicapped;
    }

    public boolean isFancy() { return isFancy; }

    public Stream<ParkingLot> parkingLotStrategy(List<ParkingLot> parkingLots) {
        if(this.isHandicapped()) {
            return parkingLots
                    .stream()
                    .filter(ParkingLot::isHandicappedFriendly);
        }
        if(this.isLarge()){
            Comparator<? super ParkingLot> byCapacity = Comparator.comparing(ParkingLot::getCapacity).reversed();
            return parkingLots
                    .stream()
                    .sorted(byCapacity);
        }
        return parkingLots.stream();
    }
}
