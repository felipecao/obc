package obc.probability;

import java.util.Objects;

public class Volume {

  private static final double CONVERSION_RATE = 3.7854;

  private double liters;

  private Volume(double liters) {
    this.liters = liters;
  }

  public static Volume liter(double liters) {
    return new Volume(liters);
  }

  public static Volume gallon(double gallons) {
    return new Volume(gallons * CONVERSION_RATE);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Volume measure = (Volume) o;
    return Double.compare(measure.liters, liters) < 0.01;
  }

  @Override
  public int hashCode() {
    return Objects.hash(liters);
  }
}
