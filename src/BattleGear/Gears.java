package battlegear;

import java.util.List;

/**
 * Interface for Gears that affect players' abilities can be temporarily, either positively or
 * negatively.
 */
public interface Gears extends Comparable<Gears> {

  /** .
   * @return Type of gear.
   */
  String getGearType();

  /**
   * .
   * @return Name of gear.
   */
  String getGearName();

  /**
   * .
   * @return affecting value of gear.
   */
  List<Integer> getGearValue();

  /**
   * .
   * @return ability being affected by the gear.
   */
  String getAbilityAffected();

  /**
   *  Used for belts.
   * @return ability being affected by the gear.
   */
  String getAbilityAffected1();

  /**
   * .
   * @return Belt size.
   */
  public BeltSize getBeltSize();

  /**
   * Sets gear value.
   */
  public void setGearValue();

  /**
   * Overrides CompareTo() to sort the gears in said order.
   * @param o of type Gears.
   * @return int.
   */
  public int compareTo(Gears o);
}
