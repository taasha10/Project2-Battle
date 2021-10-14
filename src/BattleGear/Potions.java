package BattleGear;


public class Potions extends AbstractGear{

  public Potions(String gearName, int gearValue) {

    super("Potion", gearName, gearValue);
  }

  protected int compareToPotions(Gears o) {
    return 0;
  }
  @Override
  public int compareTo(Gears o) {

    AbstractGear g = (AbstractGear) o;
    if (g.compareToPotions(this) == 0) {
      return this.getGearName().compareTo(g.getGearName());
    } else if(g.compareToHeadGears(this)==0){
      return 1;
    }
    else {
      return -1;
    }

  }
}
