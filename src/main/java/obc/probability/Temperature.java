package obc.probability;

public class Temperature extends Measure {

    protected Temperature(double i) {
        super(i);
    }

    public static Measure fareheit(double degrees) {
        return new Measure((degrees - 32) * 5.0/9);
    }

    public static Measure celsius(double degrees) {
        return new Measure(degrees);
    }
}
