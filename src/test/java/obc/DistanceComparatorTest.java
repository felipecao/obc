package obc;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class DistanceComparatorTest {

    @Test
    public void testIsEqualDistance() {
        Measure measure = new Measure(5, "meter");
        Measure measure2 = new Measure(1.5, "meter");
        Unit meters = DistanceComparator.Unit.METER
        assertTrue(DistanceComparator.isSameDistance(measure, 1.524));
    }

    @Test
    public void testIsEqualDistanceBetweenYardsAndInches() {
        assertTrue(DistanceComparator.isSameDistance(1, 0.0278));
    }
}

