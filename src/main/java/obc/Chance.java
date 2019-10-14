package obc;

import java.util.Objects;

public class Chance {

    private final int numerator;
    private final int denominator;

    public Chance(final int numerator, final int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public static Chance ofGetting(int totalPossibilities) {
        return new Chance(1, totalPossibilities);
    }

    public static Chance ofNotGetting(int totalPossibilities) {
        return ofGetting(totalPossibilities).negate();
    }

    public Chance negate() {
        return new Chance(denominator - numerator, denominator);
    }

    public Chance and(Chance other) {
        int productOfNumerators = numerator * other.numerator;
        int productOfDenominators = denominator * other.denominator;
        return new Chance(productOfNumerators, productOfDenominators);
    }

    public Chance or(Chance other) {
        return this.negate().and(other.negate()).negate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chance chance = (Chance) o;
        return numerator == chance.numerator &&
                denominator == chance.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }
}