package obc.probability;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Measure {
  @Override
  public String toString() {
    return "Measure{" +
            "value=" + value +
            '}';
  }

  protected double value;

  protected Measure(double i) {
    this.value = i;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Measure measure = (Measure) o;
    return round(measure.value) == round(value);
  }

  private double round(double v) {
    BigDecimal bd = new BigDecimal(v).setScale(4, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
