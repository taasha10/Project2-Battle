package battleweapons;

/** Represents a sword. Swords come in three varieties: Katanas, Broad Swords, two-handed swords.
 *
 */
public abstract class Swords extends AbstractWeapon {
  Swords(String weaponName, String weaponType) {
    super(weaponName, weaponType);
  }
}
