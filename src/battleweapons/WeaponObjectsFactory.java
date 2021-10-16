package battleweapons;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory class for creating objects of type Weapon.
 */
public class WeaponObjectsFactory {

  private Weapons getWeapon(String weaponType, String weaponName) {
    switch (weaponType) {
      case "Axes":
        return new Axes(weaponName);
      case "Flails":
        return new Flails(weaponName);
      case "Katanas":
        return new Katanas(weaponName);
      case "Two Handed Swords":
        return new TwoHandedSwords(weaponName);
      case "Broad Swords":
        return new BroadSwords(weaponName);
      default:
        return null;
    }

  }

  /** Method to return objects of Weapon type.
   *
   * @return List of weapons.
   */
  public List<Weapons> createWeapons() {
    List<Weapons> weaponList = new ArrayList<>();

    weaponList.add(getWeapon("Axes", "Arched Broadaxe"));
    weaponList.add(getWeapon("Axes", "Edge of Death"));
    weaponList.add(getWeapon("Axes", "Dominance"));

    weaponList.add(getWeapon("Flails", "Nightfall"));
    weaponList.add(getWeapon("Flails", "Amnesia"));
    weaponList.add(getWeapon("Flails", "Shadowfury"));

    weaponList.add(getWeapon("Katanas", "Reaper"));
    weaponList.add(getWeapon("Katanas", "Despair"));
    weaponList.add(getWeapon("Katanas", "Spiteblade"));

    weaponList.add(getWeapon("Broad Swords", "Glimmer"));
    weaponList.add(getWeapon("Broad Swords", "Needle"));
    weaponList.add(getWeapon("Broad Swords", "Slayer"));

    weaponList.add(getWeapon("Two Handed Swords", "Vengeance"));
    weaponList.add(getWeapon("Two Handed Swords", "Deathraze"));
    weaponList.add(getWeapon("Two Handed Swords", "Venom"));

    return weaponList;
  }
}
