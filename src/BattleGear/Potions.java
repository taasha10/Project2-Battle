package battlegear;

/**
 * Represents Potions that are consumed by the player before entering the field of battle.
 * They can temporarily affect any of the player's abilities. There is no limit to the number
 * of these that the player can drink.
 */
public class Potions extends AbstractGear {

  /**
   * Constructor.
   * @param gearName .
   * @param gearValue .
   */
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
    } else if (g.compareToHeadGears(this) == 0) {
      return 1;
    } else {
      return -1;
    }

  }
}
