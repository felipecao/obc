package obc.probability;

import java.util.Objects;

public class Measure {

  private double value;

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
    return Double.compare(measure.value, value) < 0.01;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
