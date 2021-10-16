package battlegear;

/** Represents Footwear that is worn on the player's feet and affects the player's dexterity.
 * Footwear always comes in pairs and a player can only wear one piece of footwear at a time.
 *
 */
public class Footwear extends AbstractGear {

  /**
   * Constructor for Footwear type of Gear.
   * @param gearName .
   * @param gearValue .
   */
  public Footwear(String gearName, int gearValue) {
    super("Foot Wear", gearName, "Dexterity", gearValue);
  }

  protected int compareToFootwear(Gears o) {
    return 0;
  }

  @Override
  public int compareTo(Gears o) {

    AbstractGear g = (AbstractGear) o;
    if (g.compareToFootwear(this) == 0) {
      return this.getGearName().compareTo(g.getGearName());
    } else {
      return 1;
    }
  }
}
