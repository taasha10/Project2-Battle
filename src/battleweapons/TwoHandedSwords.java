package battleweapons;

/** Represents Two-handed swords. IT's a heavy sword that can only be effectively wielded by
 * players with strength greater than 14, but they can do 8-12 points of damage when they hit.
 * If the player does not have the strength to wield a two-handed sword, the sword only does
 * half damage.
 *
 */
public class TwoHandedSwords extends Swords {

  TwoHandedSwords(String weaponName) {
    super(weaponName, "Two Handed Swords");
  }
}
