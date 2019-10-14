package obc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    @Test
    public void area_is_width_multiplied_by_height() {
        Rectangle rectangle = new Rectangle(5, 3);

        assertEquals(15, rectangle.area());
    }

    @Test
    public void perimeter_is_the_sum_of_sides() {
        Rectangle rectangle = new Rectangle(5, 3);

        assertEquals(16, rectangle.perimeter());
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_values_are_not_allowed() {
        new Rectangle(-5, 3);
    }
}
