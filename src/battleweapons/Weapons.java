package battleweapons;

/** Interface for Weapons that a player can wield.
 */
public interface Weapons {
  /**.
   *.
   * @return Type of Weapon.
   */
  String getWeaponType();

  /**.
   *.
   * @return Name of the weapon.
   */
  String getWeaponName();
}
