package obc.probability;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolumeUnitTest {

  @Test
  public void canCompareMeterAndCm() {
    Volume gallon = Volume.gallon(12);
    Volume liter = Volume.liter(3.7854);
    assertEquals(gallon, liter);
  }
}