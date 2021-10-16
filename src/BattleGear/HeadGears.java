package battlegear;

/**
 * Represents Headgear that is worn on the player's head and affects the player's constitution.
 * Since a player has one head, they can only wear one piece of headgear.
 */
public class HeadGears extends AbstractGear {

  /**
   * Constructor.
   * @param gearName .
   * @param gearValue .
   */
  public HeadGears(String gearName, int gearValue) {
    super("Head Gear", gearName, "Constitution", gearValue);
  }

  protected int compareToHeadGears(Gears o) {
    return 0;
  }

  @Override
  public int compareTo(Gears o) {
    AbstractGear g = (AbstractGear) o;
    if (g.compareToHeadGears(this) == 0) {
      return this.getGearName().compareTo(g.getGearName());
    } else {
      return -1;
    }
  }

}
