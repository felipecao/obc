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
}