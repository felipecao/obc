package obc.probability;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class TemperatureTest {

  @Test
  public void canCompareCelsiusAndF() {
    Temperature f = Temperature.fahrenheit(80);
    Temperature c = Temperature.celsius(26.6667);
    assertTrue(f.equalsTo(c));
  }

  @Test
  public void canAddCelsius() {
    Temperature expectedTemperature = Temperature.celsius(30);
    Temperature fifteen = Temperature.celsius(15);
    assertThat(expectedTemperature, is(fifteen.add(fifteen)));
  }
}