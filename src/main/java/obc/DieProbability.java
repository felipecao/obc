package obc;

public class DieProbability {
    private int numberOfSides;

    public DieProbability(int numberOfSides) {

        this.numberOfSides = numberOfSides;
    }

    public double chanceOfSix() {
        return 1.0/numberOfSides;
    }

    public double chanceOfNotASix() {
        return 1 - chanceOfSix();
    }
}
