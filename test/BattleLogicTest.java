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

/**
 * Class to test the BattleLogic class and its public methods.
 */
public class BattleLogicTest {

  BattleLogic battleLogic;
  Player player1;
  Player player2;
  GearObjectsFactory gearObjectsFactory;
  WeaponObjectsFactory weaponObjectsFactory;
  Abilities abTestMin;
  Abilities abTestAvg;

  @Before
  public void setUp() throws Exception {
    abTestMin = new Abilities(2);
    abTestAvg = new Abilities(4);
    player1 = new Player(1, abTestMin);
    player2 = new Player(2, abTestAvg);
    gearObjectsFactory = new GearObjectsFactory();
    weaponObjectsFactory = new WeaponObjectsFactory();

    Gears headGear = new HeadGears("Leather Cap", 1);
    Gears footwear = new Footwear("Faithful Silver Feet", 1);
    Gears potions = new Potions("Tonic of Foresight", 5);
    Gears belt = new Belts("Wicked Belt of the Dead II", 7);
    List<Gears> playerGears = new ArrayList<>(List.of(headGear, footwear, potions, belt));
    player1.setPlayerGears(playerGears);
    player1.setPlayerWeapon(List.of(weaponObjectsFactory.createWeapons().get(14)));
    player1.calEffectiveAbilities("Strength", 5);
    player1.calEffectiveAbilities("Dexterity", 3);

    Gears headGear2 = new HeadGears("Floating Crown", 4);
    Gears footwear2 = new Footwear("Walkers of Lost Fires", 3);
    Gears potions2 = new Potions("Tonic of Foresight II", 2);
    Gears belt2 = new Belts("Cord of Unholy Souls");
    List<Gears> playerGears2 = new ArrayList<>(List.of(headGear2, footwear2, potions2, belt2));
    player2.setPlayerGears(playerGears2);
    player2.setPlayerWeapon(List.of(weaponObjectsFactory.createWeapons().get(2)));
    player2.calEffectiveAbilities("Constitution", 3);
    player2.calEffectiveAbilities("Strength", 3);

    battleLogic = new BattleLogic(player1, player2);
  }

  @Test
  public void testCreatePlayer() {
    assertEquals("[Player{playerId='Player 1', abilities=Abilities{strength=6, "
                    + "constitution=6, dexterity=6, charisma=6}}, Player{playerId='Player 2', "
                    + "abilities=Abilities{strength=12, constitution=12, dexterity=12, "
            + "charisma=12}}]", battleLogic.createPlayer().toString());

  }

  @Test
  public void testDescPlayerBeforeBattle() {
    assertEquals("{Player 1 :={Effective Abilities :=Abilities{strength=26, "
            + "constitution=6, dexterity=18, charisma=6}, Gears :=[{'Leather Cap' :: 'Head Gear'},"
            + " {'Tonic of Foresight' :: 'Potion'}, {'Wicked Belt of the Dead II' :: 'Belt'}, "
            + "{'Faithful Silver Feet' :: 'Foot Wear'}], Weapon :=[{'Venom :: "
            + "Two Handed Swords'}]},"
            + " Player 2 :={Effective Abilities :=Abilities{strength=24, constitution=24, "
            + "dexterity=12, charisma=12}, Gears :=[{'Floating Crown' :: 'Head Gear'}, {'Tonic of"
            + " Foresight II' :: 'Potion'}, {'Cord of Unholy Souls' :: 'Belt'}, {'Walkers of "
            + "Lost Fires' :: 'Foot Wear'}], Weapon :=[{'Dominance :: Axes'}]}}",
            battleLogic.descPlayerBeforeBattle(player1, player2).toString());
  }

  @Test
  public void testStartBattle() {
    assertEquals("{1=[Player 2, Hit!, 25], 2=[Player 1, Hit!, 7], 3=[Player 2, Hit!, "
            + "25], 4=[Player 1, Hit!, 7], 5=[Player 2, Hit!, 25], 6=[Player 1, Hit!, 7]}",
            battleLogic.startBattle(player1, player2).toString());
  }
}

