package obc;

public class Car {

    private final String licence;

    public Car() {
        this.licence = null;
    }

    public Car(String licence) {
        this.licence = licence;
    }

    public final static Car NULL_CAR = new Car();
}
