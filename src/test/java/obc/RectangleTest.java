package obc;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class RectangleTest {

    private final int base = 5;
    private final int height = 4;
    private Rectangle rectangle = new Rectangle(base, height);

    @Test public void shouldReturnArea_WhenGivenBaseAndHeight(){


        assertThat(20, is(rectangle.calculateArea()));
    }

    @Test public void shouldReturnPerimeter_WhenGivenBaseAndHeight() {
        int perimeter = 2 * base + 2 * height;
        assertThat(perimeter, is(rectangle.calculatePerimeter()));
    }


}