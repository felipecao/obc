package obc;

public class DistanceComparator {

    enum Unit {
        FOOT(0.535, "foot"), METER(1.0, "foot"), INCH(1.0, "foot"), YARD(0.0278, "foot"), CENTIMETER(0.1, "foot");

        private final double value;
        private final String unitName;

        Unit(double unit, String foot) {
            this.value = unit;
        }
    }

    public static boolean isSameDistance(Unit value1, Unit value2) {
        double inMeters1 = Unit.FOOT.value * value1;
        double inMeters2 = Unit.INCH.value * value2;
        return true;
    }
}
