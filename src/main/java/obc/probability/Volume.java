package obc.probability;

import java.util.Objects;

public class Volume {

  private double value;

  enum VolumeUnit {

    Gal(3.7854);

    double value;

    VolumeUnit(double v) {
      this.value = v;
    }
  }

  private Volume(double i) {
    this.value = i;
  }

  public static Volume liter(double vol) {
    return new Volume(vol);
  }

  public static Volume gallon(double vol) {
    return new Volume(vol * VolumeUnit.Gal.value);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Volume measure = (Volume) o;
    return Double.compare(measure.value, value) < 0.01;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
