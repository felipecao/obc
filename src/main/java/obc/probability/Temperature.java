package obc.probability;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Temperature {

  private final double value;

  public Temperature(double value) {
    this.value = value;
  }

  public static Temperature fahrenheit(double i) {
    return new Temperature((i -32) * 5/9);
  }

  public static Temperature celsius(double v) {
    return new Temperature(v);
  }

  public boolean equalsTo(Temperature c) {
    return round(this.value) == round(c.value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Temperature that = (Temperature) o;
    return equalsTo(that);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  private double round(double v) {
    BigDecimal bd = new BigDecimal(v).setScale(4, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }

  @Override
  public String toString() {
    return "Temperature{" +
        "value=" + value +
        '}';
  }
}
