package random;

import battlegear.Gears;
import battleweapons.WeaponObjectsFactory;
import battleweapons.Weapons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** Class extending Random class and performing randomness in the project.
 *
 */
public class RandomGen extends Random {

  /** Returns 2 to 6.
   *
   * @return .
   */
  public int roll6() {
    return 2 + nextInt(5);
  }

  private int random4() {
    return 1 + nextInt(4);
  }

  /** Randomly returns an ability.
   *.
   * @return ability affected by potion .
   * @throws IllegalArgumentException if wrong input given.
   */
  public String randomPotion() throws IllegalArgumentException {
    switch (random4()) {
      case 1:
        return "Strength";
      case 2:
        return "Constitution";
      case 3:
        return "Dexterity";
      case 4:
        return "Charisma";
      default:
        throw new IllegalArgumentException("Ability not found! Choose number 1-4");
    }
  }

  /** Returns new bag after applying 25% negatives to the gear and returning two list of bags
   * of 20 gears each for players.
   *
   * @param ogBag Original bag of 62 items.
   * @return .
   */
  public List<List<Gears>> randomItems(List<Gears> ogBag) {
    List<Gears> bag = randomNegatives(ogBag);
    List<Gears> gearsList1 = new ArrayList<>();
    List<Gears> gearsList2 = new ArrayList<>();
    for (int i = bag.size(); bag.size() > 42; i--) {
      gearsList1.add(bag.remove(nextInt(i)));
    }
    for (int i = bag.size(); bag.size() > 22; i--) {
      gearsList2.add(bag.remove(nextInt(i)));
    }
    return List.of(gearsList1, gearsList2);
  }

  private List<Gears> randomNegatives(List<Gears> bag) {

    List<Gears> updated_bag = new ArrayList<>();
    for (int i = bag.size(); bag.size() > 49; i--) {
      int x = nextInt(i);
      bag.get(x).setGearValue();
      updated_bag.add(bag.remove(x));
    }
    updated_bag.addAll(bag);
    return updated_bag;
  }

  /**.
   *.
   * @return Returns 0 to 1.
   */
  public int random0To1() {
    return nextInt(2);
  }

  /**.
   *
   * @return Returns 1 to 10.
   */
  public int random1To10() {
    return 1 + nextInt(10);
  }

  /**.
   *
   * @return Returns 1 to 6.
   */
  public int random1To6() {
    return 1 + nextInt(6);
  }

  /** Randomly selects a weapon from a pool of 14.
   *
   * @return a weapon.
   */
  public Weapons randomSelectionOfWeapon() {
    WeaponObjectsFactory weaponObjectsFactory = new WeaponObjectsFactory();
    List<Weapons> weaponsList = weaponObjectsFactory.createWeapons();
    return weaponsList.get(1 + nextInt(14));
  }

  /** Returns value in the said range for different abilities and different weapons.
   *
   * @param weapon .
   * @param ability .
   * @return damage value of a weapon.
   * @throws IllegalArgumentException if arguments are wrong.
   */
  public int weaponRange(Weapons weapon, int ability) throws IllegalArgumentException {

    switch (weapon.getWeaponType()) {
      case "Axes":
      case "Broad Swords":
        return 6 + nextInt(5);
      case "Katanas":
        return 4 + nextInt(3);
      case "Two Handed Swords":
      case "Flails":
        if (ability > 14) {
          return 8 + nextInt(5);
        } else {
          return 4 + nextInt(3);
        }
      default:
        throw new IllegalArgumentException("Illegal weapon or ability value!");
    }
  }
}

