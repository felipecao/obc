package obc.probability;

public class ParkingAssistant {
    private final CollectionParkingLot collectionParkingLot;

    public ParkingAssistant(CollectionParkingLot collectionParkingLot) {
        this.collectionParkingLot = collectionParkingLot;
    }

    public ParkingAssistant(ParkingLot... parkingLots) {
        this.collectionParkingLot = new CollectionParkingLot(parkingLots);
    }

    public void parkCar(String plate1) {
        collectionParkingLot.park(plate1);
    }

    public void retrieveCar() {
        collectionParkingLot.unpark();
    }
}
