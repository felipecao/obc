package obc.probability;

import java.util.Objects;

public class Measure {

  private double value;

  @Override
  public String toString() {
    return value + "";
  }

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
    return Double.compare(measure.value, value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  public Measure add(Measure unitInMeters) {
    return new Measure(this.value + unitInMeters.value);
  }
}
