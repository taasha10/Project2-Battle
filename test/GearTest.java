import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import battlegear.BeltSize;
import battlegear.GearObjectsFactory;
import battlegear.Gears;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Class to test the Gears interface methods and respective implementing Abstract and concrete
 * classes .
 */
public class GearTest {

  GearObjectsFactory gearObjectsFactory = new GearObjectsFactory();
  List<Gears> gears;

  @Before
  public void setUp() throws Exception {
    gears = gearObjectsFactory.createGear();
  }

  @Test
  public void testGetGearType() {
    assertEquals("Head Gear", gears.get(0).getGearType());
    assertEquals("Potion", gears.get(16).getGearType());
    assertEquals("Belt", gears.get(37).getGearType());
    assertEquals("Foot Wear", gears.get(60).getGearType());
  }

  @Test
  public void testGetGearName() {
    assertEquals("Leather Cap", gears.get(0).getGearName());
  }

  @Test
  public void testGetGearValue() {
    assertEquals(List.of(1), gears.get(0).getGearValue());
    assertEquals(List.of(1, 2), gears.get(33).getGearValue());
    assertEquals(List.of(), gears.get(36).getGearValue());
  }

  @Test
  public void testGetAbilityAffected() {
    for (int i = 0; i < 10; i++) {
      assertEquals("Constitution", gears.get(i).getAbilityAffected());
    }

    for (int i = gears.size() - 1; i > 52; i--) {
      assertEquals("Dexterity", gears.get(i).getAbilityAffected());
    }

    for (int i = 10; i < 31; i++) {
      String s = gears.get(i).getAbilityAffected();
      assertTrue(s.equals("Dexterity") || s.equals("Constitution") || s.equals("Strength")
              || s.equals("Charisma"));
    }

    for (int i = 31; i < 52; i++) {
      String s = gears.get(i).getAbilityAffected();
      assertTrue(s.equals("Dexterity") || s.equals("Constitution") || s.equals("Strength")
              || s.equals("Charisma") || s.equals("NA"));
    }

  }

  @Test
  public void testGetAbilityAffected1() {
    for (int i = 0; i < 62; i++) {
      String s = gears.get(i).getAbilityAffected1();
      if (i > 30 && i < 52) {
        assertTrue(s.equals("Dexterity") || s.equals("Constitution") || s.equals("Strength")
                || s.equals("Charisma") || s.equals("NA"));
      } else {
        assertEquals("NA", s);
      }
    }
  }

  @Test
  public void testGetBeltSize() {
    for (int i = 0; i < 62; i++) {
      BeltSize s = gears.get(i).getBeltSize();
      if (i > 30 && i < 52) {
        assertTrue(s.equals(BeltSize.small) || s.equals(BeltSize.medium)
                || s.equals(BeltSize.large));
      } else {
        assertNull(s);
      }
    }
  }

  @Test
  public void testToString() {
    assertEquals("{'Leather Cap' :: 'Head Gear'}", gears.get(0).toString());
  }

  @Test
  public void testCompareTo() {
    Collections.sort(gears);
    assertEquals("[{'Crown of God' :: 'Head Gear'}, {'Crown of Jewels' :: 'Head Gear'}, "
            + "{'Floating Crown' :: 'Head Gear'}, {'Leather Cap' :: 'Head Gear'}, {'Lucky Cap' :: "
            + "'Head Gear'}, {'Lure Cap' :: 'Head Gear'}, {'Ninja Hood' :: 'Head Gear'}, "
            + "{'Prophet's Hat' :: 'Head Gear'}, {'Thunder Crown' :: 'Head Gear'}, "
            + "{'Wooden Cap' :: 'Head Gear'}, {'Elixir of Flight' :: 'Potion'}, "
            + "{'Elixir of Flight II' :: 'Potion'}, {'Elixir of Holy Protection' :: 'Potion'}, "
            + "{'Elixir of Holy Protection II' :: 'Potion'}, "
            + "{'Elixir of Holy Protection III' :: 'Potion'}, {'Flask of Honesty' :: 'Potion'}, "
            + "{'Flask of Honesty II' :: 'Potion'}, {'Potion of Focus' :: 'Potion'}, "
            + "{'Potion of Focus II' :: 'Potion'}, {'Tonic of Curing' :: 'Potion'}, "
            + "{'Tonic of Curing II' :: 'Potion'}, {'Tonic of Foresight' :: 'Potion'}, "
            + "{'Tonic of Foresight' :: 'Potion'}, {'Tonic of Foresight II' :: 'Potion'}, "
            + "{'Tonic of Foresight III' :: 'Potion'}, {'Vial of Pleasure' :: 'Potion'}, "
            + "{'Vial of Pleasure II ' :: 'Potion'}, {'Vial of Thunder' :: 'Potion'}, "
            + "{'Vial of Thunder II' :: 'Potion'}, {'Vial of the Seer' :: 'Potion'}, "
            + "{'Vial of the Seer II' :: 'Potion'}, {'Belt of Divine Kings' :: 'Belt'}, "
            + "{'Belt of Divine Kings II' :: 'Belt'}, {'Belt of the champions' :: 'Belt'}, "
            + "{'Champion Hide Sash' :: 'Belt'}, {'Champion Hide Sash II' :: 'Belt'}, "
            + "{'Cord of Unholy Souls' :: 'Belt'}, {'Cord of Unholy Souls II' :: 'Belt'}, "
            + "{'Dragon's Silk Waistband' :: 'Belt'}, {'Dragon's Silk Waistband II' :: 'Belt'}, "
            + "{'Frost Leather Girdle' :: 'Belt'}, {'Frost Leather Girdle II' :: 'Belt'}, "
            + "{'Pride's Girdle of the Princess' :: 'Belt'}, "
            + "{'Pride's Girdle of the Princess II' :: 'Belt'}, "
            + "{'Promised Strap of Suffering's End' :: 'Belt'}, "
            + "{'Promised Strap of Suffering's End II' :: 'Belt'}, "
            + "{'Sash of Twisted Fortunes' :: 'Belt'}, {'Sash of Twisted Fortunes II' :: 'Belt'}, "
            + "{'Strap of Infinite Illusions' :: 'Belt'}, "
            + "{'Strap of Infinite Illusions II' :: 'Belt'}, "
            + "{'Wicked Belt of the Dead' :: 'Belt'}, {'Wicked Belt of the Dead II' :: 'Belt'}, "
            + "{'Brutal Silk Sprinters' :: 'Foot Wear'}, "
            + "{'Conqueror's Warboots of Immortality' :: 'Foot Wear'}, "
            + "{'Faithful Silver Feet' :: 'Foot Wear'}, {'Firesoul Treads of Ice' :: 'Foot Wear'}, "
            + "{'Padded Sprinters' :: 'Foot Wear'}, {'Primal Hide Footpads' :: 'Foot Wear'}, "
            + "{'Prime Boots of Kings' :: 'Foot Wear'}, {'Reforged Mail Feet' :: 'Foot Wear'}, "
            + "{'Walkers of Lost Fires' :: 'Foot Wear'}, "
            + "{'Warboots of Frozen Warlords' :: 'Foot Wear'}]", gears.toString());

  }
}
