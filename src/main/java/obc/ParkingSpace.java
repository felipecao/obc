package obc;

public class ParkingSpace {
    private Car car;

    public ParkingSpace() {
        this.car = Car.NULL_CAR;
    }

    public boolean park(Car car) {
        if (this.car == Car.NULL_CAR) {
            this.car = car;
            return true;
        }
        return false;
    }

    public Car getParkedCar() {
        return car;
    }

    public Car retrieve(Car car) {
        if (car.equals(this.car)) {
            Car parkedCar = car;
            this.car = Car.NULL_CAR;
            return parkedCar;
        }
        return Car.NULL_CAR;
    }
}
