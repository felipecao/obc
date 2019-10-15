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
}