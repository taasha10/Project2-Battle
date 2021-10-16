package battleweapons;

/** Represents Flails type of weapon that are great general weapons, but they can only be
 * effectively wielded by players with a dexterity greater than 14. They do 8-12 points of damage
 * when they hit.
 * If the player does not have the dexterity to wield a flail, the flail only does half damage.
 *
 */
public class Flails extends AbstractWeapon {

  Flails(String weaponName) {
    super(weaponName, "Flails");
  }
}
