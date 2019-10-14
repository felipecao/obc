package obc;

public class Probability {
    private Die die;

    public Probability(Die die) {

        this.die = die;
    }

    public float chanceToGet(int value){
        return 0.16666667F;
    }

    public float chanceToNotGet(int value) {
        return 1F - 1F/die.getNumberOfSide();
    }
}

class Die {
    private int numberOfSide;
    public Die(int numberOfSide) {
        this.numberOfSide = numberOfSide;
    }

    public int getNumberOfSide() {
        return this.numberOfSide;
    }
}


