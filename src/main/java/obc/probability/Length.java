package obc.probability;

public class Length extends Measure {


  enum LengthUnit {

    CM(0.01), IM(0.0254);

    double length;

    LengthUnit(double v) {
      this.length = v;
    }
  }

  private Length(double len) {
    super(len);
  }

  public static Measure meter(double i) {
    return new Measure(i);
  }

  public static Measure cm(double i) {
    return new Measure(i * LengthUnit.CM.length);
  }

  public static Measure inch(double i) {
    System.out.println(i * LengthUnit.IM.length);
    Measure newMeasure = new Measure(i * LengthUnit.IM.length);

    return newMeasure;
  }
}
