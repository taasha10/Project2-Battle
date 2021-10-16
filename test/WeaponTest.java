import org.junit.Before;
import org.junit.Test;

import java.util.List;

import battleweapons.WeaponObjectsFactory;
import battleweapons.Weapons;

import static org.junit.Assert.assertEquals;

/**
 * Class to test the Weapons interface methods and respective implementing Abstract and concrete
 * classes .
 */

public class WeaponTest {

  WeaponObjectsFactory weaponObjectsFactory = new WeaponObjectsFactory();
  List<Weapons> weapons;

  @Before
  public void setUp() {
    weapons = weaponObjectsFactory.createWeapons();
  }

  @Test
  public void testGetWeaponName() {
    assertEquals("Arched Broadaxe", weapons.get(0).getWeaponName());

  }

  @Test
  public void testGetWeaponType() {
    assertEquals("Axes", weapons.get(0).getWeaponType());
    assertEquals("Flails", weapons.get(3).getWeaponType());
    assertEquals("Katanas", weapons.get(6).getWeaponType());
    assertEquals("Broad Swords", weapons.get(9).getWeaponType());
    assertEquals("Two Handed Swords", weapons.get(12).getWeaponType());
  }


  @Test
  public void testToString() {
    assertEquals("{'Arched Broadaxe :: Axes'}", weapons.get(0).toString());
  }
}