package obc.probability;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolumeUnitTest {

  @Test
  public void canCompareMeterAndCm() {
    Measure gallon = Volume.gallon(12);
    Measure liter = Volume.liter(3.7854);
    assertEquals(gallon, liter);
  }
}