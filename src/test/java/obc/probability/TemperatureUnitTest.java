package obc.probability;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TemperatureUnitTest {

    @Test
    public void compareTemperatures() {
        Measure temp1 = Temperature.fareheit(80);
        Measure temp2 = Temperature.celsius(26.6667);

        assertEquals(temp2, temp1);
    }

    @Test
    public void addCelsius() {
        Measure temp1 = Temperature.celsius(80);
        Measure temp2 = Temperature.celsius(80);

        assertEquals(Temperature.celsius(160), temp1.add(temp2));
    }
}
