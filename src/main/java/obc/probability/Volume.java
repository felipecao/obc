package obc.probability;

public class Volume extends Measure {

  enum VolumeUnit {

    Gal(3.7854);

    double value;

    VolumeUnit(double v) {
      this.value = v;
    }
  }

  private Volume(double volume) {
    super(volume);
  }

  public static Measure liter(double vol) {
    return new Volume(vol);
  }

  public static Measure gallon(double vol) {
    return new Volume(vol * VolumeUnit.Gal.value);
  }
}
