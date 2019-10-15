package obc.probability;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProbabilityTest {

  @Test
  public void of() {
    Probability p = Probability.of(6);
    Probability expected = new Probability(0.16666666666666666);
    assertEquals(expected, p);
  }

  @Test
  public void inverse() {
    Probability p = Probability.of(6);
    Probability expected = new Probability(0.8333333333333334);
    assertEquals(expected, p.inverse());
  }

  @Test
  public void multiply() {
    Probability pA = Probability.of(10);
    Probability pB = Probability.of(5);

    Probability expected = new Probability(0.02);
    assertEquals(expected, pA.multiplyBy(pB));
  }

  @Test
  public void or() {
    Probability pA = Probability.of(10);
    Probability pB = Probability.of(5);

    Probability expected = new Probability(0.28);
    assertEquals(expected, pA.or(pB));
  }
}