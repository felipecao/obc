package obc;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void testAreaForRectangle() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(12, rectangle.getArea());
    }

    @Test
    public void testAreaForAnotherRectangle() {
        Rectangle rectangle = new Rectangle(2, 7);
        assertEquals(14, rectangle.getArea());
    }

    @Test
    public void testPerimeterForRectangle() {
        Rectangle rectangle = new Rectangle(2, 7);
        assertEquals(18, rectangle.getPerimeter());
    }

    @Test
    public void testPerimeterForAnotherRectangle() {
        Rectangle rectangle = new Rectangle(3, 4);
        assertEquals(14, rectangle.getPerimeter());
    }

    @Test(expected = RuntimeException.class)
    public void testRectangleDoNotHaveNegativeHeight() {
        new Rectangle(-3, 4);
    }

    @Test(expected = RuntimeException.class)
    public void testRectangleDoNotHaveZeroHeight() {
        new Rectangle(0, 4);
    }

    @Test(expected = RuntimeException.class)
    public void testRectangleDoNotHaveZeroWidth() {
        new Rectangle(3, 0);
    }

    @Test(expected = RuntimeException.class)
    public void testRectangleDoNotHaveNegativeWidth() {
        new Rectangle(3, -4);
    }


}