package battleweapons;

/**
 * Abstract class for different types of weapons.
 */
public abstract class AbstractWeapon implements Weapons {
  protected final String weaponName;
  protected final String weaponType;

  protected AbstractWeapon(String weaponName, String weaponType) {
    this.weaponName = weaponName;
    this.weaponType = weaponType;
  }

  @Override
  public String getWeaponName() {
    return weaponName;
  }


  @Override
  public String getWeaponType() {
    return weaponType;
  }

  @Override
  public String toString() {
    return "{'" + weaponName + " :: " + weaponType + '\'' + '}';
  }
}
