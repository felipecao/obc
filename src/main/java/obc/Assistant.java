package obc;

public class Assistant {
    public void park(Car car, ParkingLot pl) {
        car.park(pl);
    }

    public void retrieve(Car car, ParkingLot pl) {
        car.unPark(pl);
    }
}
