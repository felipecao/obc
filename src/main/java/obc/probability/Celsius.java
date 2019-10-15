package obc.probability;

public class Celsius extends Measure {

    protected Celsius(double i) {
        super(i);
    }

    public static Celsius fromFh(double value) {
        return new Celsius((value - 32) * (5.0/9));
    }

    public static Celsius fromValue(double value) {
        return new Celsius(value);
    }

    public Celsius add(Celsius otherCelsius) {
        return new Celsius(value + otherCelsius.value);
    }
}
