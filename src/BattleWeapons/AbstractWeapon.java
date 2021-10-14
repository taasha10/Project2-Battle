package BattleWeapons;

public abstract class AbstractWeapon implements Weapons{
  protected final String weaponName;
  protected final String weaponType;
//  protected int damageValue;

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
    return "{'" + weaponName + "\' :: '" +
            weaponType + '\'' +
            '}';
  }
}
