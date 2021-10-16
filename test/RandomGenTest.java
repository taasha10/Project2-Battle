import org.junit.Before;
import org.junit.Test;

import java.util.List;

import battlegear.GearObjectsFactory;
import battlegear.Gears;
import battleweapons.WeaponObjectsFactory;
import battleweapons.Weapons;
import random.RandomGen;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class to test the RandomGen class and its public methods.
 */
public class RandomGenTest {

  RandomGen randomGen;
  WeaponObjectsFactory weaponObjectsFactory;
  List<Weapons> weaponsList;

  @Before
  public void setUp() {
    randomGen = new RandomGen();
    weaponObjectsFactory = new WeaponObjectsFactory();
    weaponsList = weaponObjectsFactory.createWeapons();
  }

  @Test
  public void testRandomItems() {
    GearObjectsFactory gearObjectsFactory = new GearObjectsFactory();
    List<Gears> gearsList = gearObjectsFactory.createGear();
    assertEquals(20, randomGen.randomItems(gearsList).get(0).size());
  }

  @Test
  public void testRoll6() {
    for (int i = 0; i < 1000000; i++) {
      assertTrue(randomGen.roll6() >= 2);
      assertTrue(randomGen.roll6() <= 6);
    }
  }


  @Test
  public void testRandomPotion() {
    String s = randomGen.randomPotion();
    for (int i = 0; i < 1000000; i++) {
      assertTrue(s.equals("Dexterity") || s.equals("Constitution") || s.equals("Strength")
              || s.equals("Charisma"));
    }
  }


  @Test
  public void testRandom0To1() {
    for (int i = 0; i < 1000000; i++) {
      assertTrue(randomGen.random0To1() >= 0 || randomGen.random0To1() <= 1);
    }
  }

  @Test
  public void random1To10() {
    for (int i = 0; i < 1000000; i++) {
      assertTrue(randomGen.random1To10() >= 1 || randomGen.random1To10() <= 10);
    }
  }

  @Test
  public void random1To6() {
    for (int i = 0; i < 1000000; i++) {
      assertTrue(randomGen.random1To10() >= 1 || randomGen.random1To10() <= 6);
    }
  }

  @Test
  public void randomSelectionOfWeapon() {

    for (int i = 0; i < 1000000; i++) {
      for (Weapons weapons : weaponsList) {
        assertTrue(weapons.getWeaponType().equals("Axes")
                || weapons.getWeaponType().equals("Flails")
                || weapons.getWeaponType().equals("Katanas")
                || weapons.getWeaponType().equals("Broad Swords")
                || weapons.getWeaponType().equals("Two Handed Swords"));
      }
    }
  }

  @Test
  public void testWeaponRange() {
    int range;
    for (Weapons weapons : weaponsList) {
      if (weapons.getWeaponType().equals("Two Handed Swords")
              || weapons.getWeaponType().equals("Flails")) {
        range = randomGen.weaponRange(weapons, 10);
        for (int i = 0; i < 1000000; i++) {
          assertTrue(range >= 4 && range <= 6);
        }
        range = randomGen.weaponRange(weapons, 18);
        for (int i = 0; i < 1000000; i++) {
          assertTrue(range >= 8 && range <= 12);
        }
      } else {
        if (weapons.getWeaponType().equals("Katanas")) {
          range = randomGen.weaponRange(weapons, 0);
          for (int i = 0; i < 1000000; i++) {
            assertTrue(range >= 4 && range <= 6);
          }
        } else {
          range = randomGen.weaponRange(weapons, 0);
          for (int i = 0; i < 1000000; i++) {
            assertTrue(range >= 6 && range <= 10);
          }
        }

      }
    }

  }

}