package obc;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProbabilityTest {
    // Die of 6 sides
    @Test public void chanceOfGetting6_when6SidesDie(){
        Die die = new Die(6);
        Probability prob = new Probability(die);
        assertThat(prob.chanceToGet(6), is(1/6F));
    }

    @Test public void chanceOfNonGetting6_when6SidesDie(){
        Die die = new Die(6);
        Probability prob = new Probability(die);
        assertThat(prob.chanceToNotGet(6), is(5/6F));
    }

    // Die of 8 sides
    @Test
    public void chanceOfNotGetting6_when8SidesDie() {
        Die die = new Die(8);
        Probability prob = new Probability(die);
        assertThat(prob.chanceToNotGet(6), is(7/8F));
    }
}
