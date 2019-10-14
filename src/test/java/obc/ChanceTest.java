package obc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChanceTest {

    @Test
    public void the_chance_of_getting_a_six_is_16_percent() {
        Chance expected = new Chance(1, 6);
        assertEquals(expected, Chance.ofGetting(6));
    }

    @Test
    public void the_chance_of_not_getting_a_six_is_84_percent() {
        Chance expected = new Chance(5, 6);
        assertEquals(expected, Chance.ofNotGetting(6));
    }

    @Test
    public void the_chance_of_product_is_the_product_of_chances() {
        Chance expected = new Chance(3, 24);
        Chance first = new Chance(1, 8);
        Chance second = new Chance(3, 3);
        assertEquals(expected, first.and(second));
    }

    @Test
    public void the_or_of_two_chances_is_the_negation_of_their_product() {
        Chance expected = new Chance(17, 24);
        Chance first = new Chance(1, 8);
        Chance second = new Chance(2, 3);
        assertEquals(expected, first.or(second));
    }
}
