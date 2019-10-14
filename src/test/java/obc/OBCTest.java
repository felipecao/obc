package obc;
import org.junit.Test;
import static org.junit.Assert.*;

public class OBCTest {

    @Test public void whenCreatingPerimeterIsZero() {
        FlatShape shape = new Rectangle();
        assertEquals(0, shape.perimeter());
    }

    @Test public void canCalculatePerimeterWhenGivenOneSide() {
        FlatShape shape = new Rectangle(5);
        assertEquals(20, shape.perimeter());
    }

    @Test public void canCalculatePerimeterWhenGivenTwoSides() {
        FlatShape shape = new Rectangle(5, 6);
        assertEquals(22, shape.perimeter());
    }

    @Test public void canCalculateAreaWithSidesOfTheSameSize() {
        FlatShape shape = new Rectangle(5);
        assertEquals(25, shape.area());
    }

    @Test public void canCalculateAreaWithTwoDifferentSides() {
        FlatShape shape = new Rectangle(5, 6);
        assertEquals(30, shape.area());
    }
}
