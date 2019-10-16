package obc.probability;

public class Length extends Measure {



  enum LengthUnit {

    CM(0.01), INCH(0.0254);

    double conversionRate;

    LengthUnit(double v) {
      this.conversionRate = v;
    }
  }

  private Length(double len) {
    super(len);
  }

  public static Measure meter(double i) {
    return new Measure(i);
  }

  public static Measure cm(double i) {
    return new Measure(i * LengthUnit.CM.conversionRate);
  }

  public static Measure inch(double inch) {return new Measure(inch * LengthUnit.INCH.conversionRate);}

}
