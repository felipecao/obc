package obc.probability;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@Ignore
public class MeasureTest {

    @Test
    public void ShouldAddInches() {
        assertEquals(Length.inch(4), Length.inch(2).add(Length.inch(2)));
    }

    @Test
    public void ShouldAddInchesAndMeters() {
        assertThat(Length.inch(41.37008), is(Length.inch(2).add(Length.meter(1))));
    }

}