package BattleGear;

public class Footwear extends AbstractGear {

  public Footwear(String gearName, int gearValue) {
    super("Foot Wear", gearName,"Dexterity", gearValue);
  }

  protected int compareToFootwear(Gears o) {
    return 0;
  }

  @Override
  public int compareTo(Gears o) {

    AbstractGear g = (AbstractGear) o;
    if (g.compareToFootwear(this) == 0) {
      return this.getGearName().compareTo(g.getGearName());
    }
    else {
      return 1;
    }
  }
}
