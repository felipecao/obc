package obc.probability;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Length {

  private double meters;

  public Length add(Length l2) {
    return new Length(meters + l2.meters);
  }

  enum LengthUnit {

    CM(0.01),
    INCH(0.0254);

    double length;

    LengthUnit(double v) {
      this.length = v;
    }
  }

  private Length(double meters) {
    this.meters = meters;
  }

  public static Length meter(double i) {
    return new Length(i);
  }

  public static Length cm(double i) {
    return new Length(i * LengthUnit.CM.length);
  }

  public static Length inch(double i) {
    return new Length(i * LengthUnit.INCH.length);
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
    return round(length.meters) == round(meters);
  }

  private double round(double v) {
    BigDecimal bd = new BigDecimal(v).setScale(4, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(meters);
  }

  @Override
  public String toString() {
    return "Length{" +
        "value=" + meters +
        '}';
  }
}
