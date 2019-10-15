package obc.probability;

import java.util.Objects;

public class Length {

  private double value;

  enum LengthUnit {

    CM(0.01);

    double length;

    LengthUnit(double v) {
      this.length = v;
    }
  }

  private Length(double i) {
    this.value = i;
  }

  public static Length meter(double i) {
    return new Length(i);
  }

  public static Length cm(double i) {
    return new Length(i * LengthUnit.CM.length);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Length length = (Length) o;
    return Double.compare(length.value, value) < 0.01;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return "Length{" +
        "value=" + value +
        '}';
  }
}
