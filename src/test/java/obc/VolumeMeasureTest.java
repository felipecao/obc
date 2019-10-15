package obc;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class VolumeMeasureTest {

    @Test
    public void testCanCompareGalWithLiters() {
        assertThat(VolumeMeasure.convert(4, "gal"), is(15.1416));
    }
}
