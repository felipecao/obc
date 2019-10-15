package obc.probability;

import org.junit.Test;
import static org.junit.Assert.*;

public class LengthUnitTest {

  @Test
  public void canCompareMeterAndCm() {
    Measure meter = Length.meter(2);
    Measure cm = Length.cm(200);
    assertEquals(meter, cm);
  }

  @Test
  public void canAddInches() {
    Length inch1 = Length.inch(2);
    Length inch2 = Length.inch(2);
    Length expected = Length.inch(4);
    assertEquals(inch1.add(inch2), expected);
  }

  @Test
  public void canAddInchesAndMeters() {
    Length inch = Length.inch(2);
    Length meter = Length.meter(1);
    Length expected = Length.inch(41.37008);
    assertEquals(inch.add(meter), expected);
  }

  @Test
  public void canCompareFahrenheitWithCelsius () {
    Celsius celsius1 = Celsius.fromFh(80);
    Celsius celsius2 = Celsius.fromValue(26.6667);
    assertEquals(celsius1, celsius2);
  }

  @Test
  public void canAddCelsius() {
    Celsius celsius1 = Celsius.fromValue(1);
    Celsius celsius2 = Celsius.fromValue(15);
    assertEquals(Celsius.fromValue(16), celsius1.add(celsius2));
  }

  @Test
  public void testAddIsConmutative() {
    Celsius celsius1 = Celsius.fromValue(6);
    Celsius celsius2 = Celsius.fromValue(15);
    assertEquals(Celsius.fromValue(21), celsius2.add(celsius1));
  }

//  @Test
//  public void canNotAddCelsiusWithMeters() {
//    Celsius celsius1 = Celsius.fromValue(15);
//    Length meter = Length.meter(15);
//    assertEquals(Celsius.fromValue(30), celsius1.add(meter));
//  }
}