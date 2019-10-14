package obc;

import org.junit.Test;
import static org.junit.Assert.*;

public class DieProbabilityTest {

    @Test public void ShouldCalculateChanceOfGettingA6_WhenRollingA6SidedDie() {
        int numberOfSides = 6;
        DieProbability dieProbability = new DieProbability(numberOfSides);

        assertEquals(0.1666, dieProbability.chanceOfSix(), 0.01);
    }

    @Test public void ShouldCalculateChanceOfGettingA6_WhenRollingA20SidedDie() {
        int numberOfSides = 20;
        DieProbability dieProbability = new DieProbability(numberOfSides);

        assertEquals(0.05, dieProbability.chanceOfSix(), 0.01);
    }

    @Test public void ShouldCalculateChanceOfNotGettingA6_WhenRollingA6SidedDie() {
        int numberOfSides = 6;
        DieProbability dieProbability = new DieProbability(numberOfSides);

        assertEquals(0.8333, dieProbability.chanceOfNotASix(), 0.01);
    }

    @Test public void ShouldCalculateChanceOfNotGettingA6_WhenRollingA20SidedDie() {
        int numberOfSides = 20;
        DieProbability dieProbability = new DieProbability(numberOfSides);

        assertEquals(0.95, dieProbability.chanceOfNotASix(), 0.01);
    }

}
