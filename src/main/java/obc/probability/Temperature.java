package obc.probability;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
