package obc.probability;

import static org.junit.Assert.*;

import org.junit.Test;

public class TemperatureTest {

  @Test
  public void canCompareCelsiusAndF() {
    Temperature f = Temperature.fahrenheit(80);
    Temperature c = Temperature.celsius(26.6667);
    assertTrue(f.equalsTo(c));
    assertTrue(f.equals(c));
  }
}