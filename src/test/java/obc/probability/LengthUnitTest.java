package obc.probability;

import org.junit.Test;
import static org.junit.Assert.*;

public class LengthUnitTest {

  @Test
  public void canCompareMeterAndCm() {
    Length meter = Length.meter(2);
    Length cm = Length.cm(200);
    assertEquals(meter, cm);
  }

  @Test public void canAddInches() {
    Length l1 = Length.inch(2);
    Length l2 = Length.inch(2);
    Length expected = Length.inch(4);
    assertEquals(expected, l1.add(l2));
  }

  @Test
  public void canAddMeterAndInch() {
    Length meter = Length.meter(1);
    Length inch = Length.inch(2);
    Length expected = Length.inch(41.37008);
    assertEquals(expected, inch.add(meter));
  }
}