package obc.probability;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LengthUnitTest {

  @Test
  public void canCompareMeterAndCm() {
    Measure meter = Length.meter(2);
    Measure cm = Length.cm(200);
    assertEquals(meter, cm);
  }

  @Test
  public void canAddSameMeasure() {
    Measure measureOne = Length.inch(1);
    Measure measureTwo = Volume.gallon(2);

    assertThat(Length.inch(3), is(measureOne.add(measureTwo)));
  }
}