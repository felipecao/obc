package obc.probability;

public class Length extends Measure {

  enum LengthUnit {

    CM(0.01),
    INCH(0.0254);

    double length;

    LengthUnit(double v) {
      this.length = v;
    }

  }

  private Length(double len) {
    super(len);
  }

  public static Length meter(double i) {
    return new Length(i);
  }

  public static Length cm(double i) {
    return new Length(i * LengthUnit.CM.length);
  }

  public static Length inch(double i) {
    return new Length(i * LengthUnit.INCH.length);
  }

  public Length add(Length length) {
    return this.meter(this.value + length.value);
  }

}
