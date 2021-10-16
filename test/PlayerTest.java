import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battlegear.Belts;
import battlegear.Footwear;
import battlegear.GearObjectsFactory;
import battlegear.Gears;
import battlegear.HeadGears;
import battlegear.Potions;
import battleweapons.WeaponObjectsFactory;
import player.info.Abilities;
import player.info.Player;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class to test the Player class and its public methods.
 */
public class PlayerTest {

  Player player;
  Player player2;
  GearObjectsFactory gearObjectsFactory;
  WeaponObjectsFactory weaponObjectsFactory;
  Abilities abTestMin;


  @Before
  public void setUp() throws Exception {
    abTestMin = new Abilities(2);
    player = new Player(11, abTestMin);
    player2 = new Player(2, abTestMin);
    gearObjectsFactory = new GearObjectsFactory();
    weaponObjectsFactory = new WeaponObjectsFactory();
    Gears headGear = new HeadGears("Leather Cap", 1);
    Gears headGear2 = new HeadGears("Wooden Cap", 1);
    Gears footwear = new Footwear("Faithful Silver Feet", 1);
    Gears footWear2 = new Footwear("Walkers of Lost Fires", 3);
    Gears potions = new Potions("Tonic of Foresight", 5);
    Gears belt = new Belts("Wicked Belt of the Dead II", 7);
    List<Gears> playerGears = new ArrayList<>(List.of(headGear, footwear, potions, belt));
    List<Gears> playerGears2 = new ArrayList<>(List.of(headGear, footwear, potions, belt,
            headGear2,headGear2));
    player.setPlayerGears(playerGears);
    player2.setPlayerGears(playerGears);
    player.setPlayerWeapon(List.of(weaponObjectsFactory.createWeapons().get(14)));
    player2.setPlayerWeapon(List.of(weaponObjectsFactory.createWeapons().get(6),
            weaponObjectsFactory.createWeapons().get(7)));
    player.calEffectiveAbilities("Strength", 5);
    player.calEffectiveAbilities("Dexterity", 3);
  }

  @Test
  public void getPlayerId() {
    assertEquals("Player 11", player.getPlayerId());
  }

  @Test
  public void getPlayerGears() {
    assertEquals("[{'Leather Cap' :: 'Head Gear'}, {'Tonic of Foresight' :: 'Potion'}, "
            + "{'Wicked Belt of the Dead II' :: 'Belt'}, {'Faithful Silver Feet' :: 'Foot "
            + "Wear'}]", player.getPlayerGears().toString());
    assertEquals("[{'Leather Cap' :: 'Head Gear'}, {'Tonic of Foresight' :: 'Potion'}, "
            + "{'Wicked Belt of the Dead II' :: 'Belt'}, {'Faithful Silver Feet' :: "
            + "'Foot Wear'}]",player2.getPlayerGears().toString());
  }

  @Test
  public void testGetPlayerWeapon() {
    assertEquals("[{'Venom :: Two Handed Swords'}]", player.getPlayerWeapon().toString());
    assertEquals("[{'Reaper :: Katanas'}, {'Despair :: Katanas'}]",
            player2.getPlayerWeapon().toString());
  }

  @Test
  public void testGetAbilities() {
    assertEquals("Abilities{strength=6, constitution=6, dexterity=6, charisma=6}",
            player.getAbilities().toString());
  }

  @Test
  public void getEffectiveAbilities() {
    assertEquals("Abilities{strength=26, constitution=6, dexterity=18, charisma=6}",
            player.getEffectiveAbilities().toString());
  }

  @Test
  public void testCalEffectiveAbilities() {
    assertEquals("Abilities{strength=26, constitution=6, dexterity=18, charisma=6}",
            player.getEffectiveAbilities().toString());
  }

  @Test
  public void testCalStrikingPower() {
    for (int i = 0; i < 1000000; i++) {
      assertTrue(player.calStrikingPower() > 26);
      assertTrue(player.calStrikingPower() < 37);
    }
    assertEquals(28, player.calStrikingPower(2));
  }

  @Test
  public void calAvoidanceAbility() {
    for (int i = 0; i < 1000000; i++) {
      assertTrue(player.calAvoidanceAbility() > 18);
      assertTrue(player.calAvoidanceAbility() < 25);
    }
    assertEquals(28, player.calAvoidanceAbility(10));
  }

  @Test
  public void testToString() {
    assertEquals("Player{playerId='Player 11', abilities=Abilities{strength=6, "
            + "constitution=6, dexterity=6, charisma=6}}", player.toString());
  }
}