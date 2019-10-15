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
}