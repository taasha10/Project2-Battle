package BattleWeapons;

import java.util.ArrayList;
import java.util.List;

public class WeaponObjectsFactory {

  private Weapons getWeapon(String weaponType, String weaponName) {
    if (weaponType == "Axes") {

      return new Axes(weaponName);
    } else if (weaponType == "Flails") {
      return new Flails(weaponName);
    } else if (weaponType == "Katanas") {
      return new Katanas(weaponName);
    } else if (weaponType == "Two Handed Swords") {
      return new TwoHandedSwords(weaponName);
    } else if (weaponType == "Broad Swords") {
      return new BroadSwords(weaponName);
    } else {
      return null;
    }

  }

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
