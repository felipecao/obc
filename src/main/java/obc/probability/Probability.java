package obc.probability;

import java.util.Objects;

public class Probability {

  final Double value;

  public Probability(Double value) {
    this.value = value;
  }

  public static Probability of(int outcomes) {
    return new Probability(1.0 / outcomes);
  }

  public Probability inverse() {
    return new Probability(1.0 - value);
  }

  public Probability multiplyBy(Probability pB) {
    return new Probability(value * pB.value);
  }

  public Probability add(Probability pB) {
    return new Probability(value + pB.value);
  }

  public Probability subtract(Probability pB) {
    return new Probability(value - pB.value);
  }

  public Probability or(Probability pB) {
    Probability aAndB = this.multiplyBy(pB);
    return this.add(pB).subtract(aAndB);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Probability that = (Probability) o;
    return Double.compare(value, that.value) < 0.01;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
