package battlegear;

import static java.lang.Math.abs;

/**
 * Represents belts of type Gear that are worn around the player's torso affecting up to two of
 * the player's abilities.
 */
public class Belts extends AbstractGear {


  BeltSize beltSize = null;

  /** Parameterized constructor for Belts class.
   *
   * @param gearName Name of the gear.
   * @param gearValue Vararg method for gear Value that affects a player's abilities.
   */
  public Belts(String gearName, int... gearValue) {

    super("Belt", gearName, gearValue);
    if (gearValue.length == 2) {
      setBeltSize(Math.max(abs(gearValue[0]), abs(gearValue[1])));
    } else if (gearValue.length == 1) {
      setBeltSize(abs(gearValue[0]));
    } else if (gearValue.length == 0) {
      setBeltSize(0);
    }
  }

  public BeltSize getBeltSize() {
    return beltSize;
  }

  private void setBeltSize(int i) {

    if (i < 5) {
      beltSize = BeltSize.small;
    } else if (i < 8) {
      beltSize = BeltSize.medium;
    } else if (i <= 15) {
      beltSize = BeltSize.large;
    }
  }

  protected int compareToBelts(Gears o) {
    return 0;
  }

  @Override
  public int compareTo(Gears o) {

    AbstractGear g = (AbstractGear) o;
    if (g.compareToBelts(this) == 0) {
      return this.getGearName().compareTo(g.getGearName());
    } else if (g.compareToFootwear(this) == 0) {
      return -1;
    } else {
      return 1;
    }
  }

}
