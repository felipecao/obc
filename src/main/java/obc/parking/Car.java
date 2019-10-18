package obc.parking;

public class Car {
    private final boolean requiresCertifiedDriver;
    private String licencePlate;

    public Car(String licencePlate) {
        this.licencePlate = licencePlate;
        this.requiresCertifiedDriver = false;
    }

    public Car(String plate, boolean requiresCertifiedDriver) {
        this.requiresCertifiedDriver = requiresCertifiedDriver;
    }

    public boolean doesRequireCertifiedDriver() {
        return requiresCertifiedDriver;
    }
}
