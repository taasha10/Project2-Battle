import battlegear.GearObjectsFactory;
import battlegear.Gears;
import battleweapons.Weapons;
import player.info.Player;
import random.RandomGen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/** Model Class to represent the battle functionalities and logic.
 */
public class BattleLogic {

  Player player1;
  Player player2;
  RandomGen randomGen;
  Map<Integer, List> roundResult;

  /**Default constructor for BattleLogic class for Driver.
   */
  public BattleLogic() {
    player1 = new Player(1);
    player2 = new Player(2);
    randomGen = new RandomGen();
    roundResult = new TreeMap<>();
  }

  /**Parameterized constructor for BattleLogic class for Testing.
   *
   * @param player1 first player
   * @param player2 second player
   */
  public BattleLogic(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
    roundResult = new TreeMap<>();
  }

  private Player getPlayer1() {
    return player1;
  }

  private Player getPlayer2() {
    return player2;
  }

  /**Method to create player in driver.
   * @return the list of two players.
   */
  public List<Player> createPlayer() {
    List<Player> listOfPlayers = new ArrayList<>();
    listOfPlayers.add(getPlayer1());
    listOfPlayers.add(getPlayer2());
    return listOfPlayers;
  }


  private void equipPlayer() {
    GearObjectsFactory gearObjectsFactory = new GearObjectsFactory();
    List<Gears> bag = gearObjectsFactory.createGear();
    List<List<Gears>> assignItems = randomGen.randomItems(bag);
    player1.setPlayerGears(assignItemsToPlayer(assignItems.get(0)));
    player2.setPlayerGears(assignItemsToPlayer(assignItems.get(1)));
    player1.calEffectiveAbilities();
    player2.calEffectiveAbilities();
  }

  private List<Gears> assignItemsToPlayer(List<Gears> gearsList) {
    boolean headGear = false;
    boolean footWear = false;
    List<Gears> finalGears = new ArrayList<>();
    int unit = 0;

    for (int i = 0; i < 20; i++) {
      Gears gear = gearsList.get(i);
      if (gear.getGearType().equals("Head Gear") && !headGear) {
        headGear = true;
        finalGears.add(gear);
      } else if (gear.getGearType().equals("Foot Wear") && !footWear) {
        footWear = true;
        finalGears.add(gear);
      } else if ((gear.getGearType().equals("Foot Wear") && footWear)
              || (gear.getGearType().equals("Head Gear") && headGear)) {
        continue;
      } else if (gear.getGearType().equals("Belt")) {

        unit = unit + gear.getBeltSize().getUnits();
        if (unit <= 10) {
          finalGears.add(gear);
        } else {
          unit = unit - gear.getBeltSize().getUnits();
        }
      } else if (gear.getGearType().equals("Potion")) {
        finalGears.add(gear);
      }
    }
    return finalGears;
  }

  private void requestWeaponFromArmory(Player p) {
    Weapons selectedWeapon = randomGen.randomSelectionOfWeapon();
    if (selectedWeapon.getWeaponType().equals("Katanas")) {
      Weapons selectedWeapon2 = randomGen.randomSelectionOfWeapon();
      if (selectedWeapon2.getWeaponType().equals("Katanas")) {
        p.setPlayerWeapon(List.of(selectedWeapon, selectedWeapon2));
      }
    }
    p.setPlayerWeapon(Collections.singletonList(selectedWeapon));
  }

  private void callRequestWeaponFromArmory() {
    requestWeaponFromArmory(getPlayer1());
    requestWeaponFromArmory(getPlayer2());
  }

  /** Method to provide a complete description of players that will enter the arena including
   * the player's temporary ability values (based on the affects of the potions that they may
   * have consumed) along with any and all the gear they are wearing, and what weapon they are
   * using. Also, returns Gear printed in order of top to bottom, then alphabetically. Used for
   * driver class.
   *
   * @return Map of Player1 , Player 2 with Gears,Weapons,Effective Abilities as values.
   */
  public Map<String, Map<String, String>> descPlayerBeforeBattle() {
    equipPlayer();
    callRequestWeaponFromArmory();

    Map<String, String> detailsOfPlayer1 = new TreeMap<>();
    detailsOfPlayer1.put("Gears :", player1.getPlayerGears().toString());
    detailsOfPlayer1.put("Weapon :", player1.getPlayerWeapon().toString());
    detailsOfPlayer1.put("Effective Abilities :", player1.getEffectiveAbilities().toString());

    Map<String, Map<String, String>> details = new TreeMap<>();
    details.put("Player 1 :", detailsOfPlayer1);

    Map<String, String> detailsOfPlayer2 = new TreeMap<>();
    detailsOfPlayer2.put("Effective Abilities :", player2.getEffectiveAbilities().toString());
    detailsOfPlayer2.put("Gears :", player2.getPlayerGears().toString());
    detailsOfPlayer2.put("Weapon :", player2.getPlayerWeapon().toString());
    details.put("Player 2 :", detailsOfPlayer2);

    return details;
  }

  /** Method to provide a complete description of players that will enter the arena including
   * the player's temporary ability values (based on the affects of the potions that they may
   * have consumed) along with any and all the gear they are wearing, and what weapon they are
   * using. Also, returns Gear printed in order of top to bottom, then alphabetically. Used for
   * testing.
   *
   * @param player1 first player called from test class.
   * @param player2 second player called from test class.
   * @return Map of Player1 , Player 2 with Gears,Weapons,Effective Abilities as values.
   */
  public Map<String, Map<String, String>> descPlayerBeforeBattle(Player player1, Player player2) {

    Map<String, String> detailsOfPlayer1 = new TreeMap<>();
    detailsOfPlayer1.put("Gears :", player1.getPlayerGears().toString());
    detailsOfPlayer1.put("Weapon :", player1.getPlayerWeapon().toString());
    detailsOfPlayer1.put("Effective Abilities :", player1.getEffectiveAbilities().toString());

    Map<String, Map<String, String>> details = new TreeMap<>();
    details.put("Player 1 :", detailsOfPlayer1);

    Map<String, String> detailsOfPlayer2 = new TreeMap<>();
    detailsOfPlayer2.put("Effective Abilities :", player2.getEffectiveAbilities().toString());
    detailsOfPlayer2.put("Gears :", player2.getPlayerGears().toString());
    detailsOfPlayer2.put("Weapon :", player2.getPlayerWeapon().toString());
    details.put("Player 2 :", detailsOfPlayer2);
    return details;
  }

  /** Method to start the battle in the arena. As players enter the arena, the player with the
   * higher charisma dazzles their opponent and gets in the first strike.
   *
   * @return Map of Round Number, Round Result.
   */
  public Map<Integer, List> startBattle() {
    if (player1.getEffectiveAbilities().getCharisma() >= player2.getEffectiveAbilities()
            .getCharisma()) {
      startRound(player1, player2);
    } else {
      startRound(player2, player1);
    }
    return roundResult;
  }

  /**Method to start the battle in the arena. As players enter the arena, the player with the
   * higher charisma dazzles their opponent and gets in the first strike. Used in testing.
   *
   * @param player1 first player called from test class.
   * @param player2 second player called from test class.
   * @return Map of Round Number, Round Result.
   */
  public Map<Integer, List> startBattle(Player player1, Player player2) {
    if (player1.getEffectiveAbilities().getCharisma() >= player2.getEffectiveAbilities()
            .getCharisma()) {
      startRoundMirror(player1, player2);
    } else {
      startRoundMirror(player2, player1);
    }
    return roundResult;
  }


  private List attack(Player attackingPlayer, Player attackedPlayer) {

    if (attackingPlayer.calStrikingPower() > attackedPlayer.calAvoidanceAbility()) {
      int potentialStrikingDamage = calPotentialStrikingDamage(attackingPlayer);
      int actualDamage = calActualDamage(potentialStrikingDamage, attackedPlayer);
      if (actualDamage > 0) {
        attackedPlayer.getEffectiveAbilities().setHealth(
                attackedPlayer.getEffectiveAbilities().getHealth() - actualDamage);
        return List.of(attackingPlayer.getPlayerId(), "Hit!", actualDamage);
      } else {
        return List.of(attackingPlayer.getPlayerId(), "Hit!", 0);
      }
    } else {
      return List.of(attackingPlayer.getPlayerId(), "Miss!", 0);
    }
  }

  private List attackMirror(Player attackingPlayer, Player attackedPlayer) {

    if (attackingPlayer.calStrikingPower(4) > attackedPlayer.calAvoidanceAbility(7)) {
      int potentialStrikingDamage = calPotentialStrikingDamageMirror(attackingPlayer);
      int actualDamage = calActualDamage(potentialStrikingDamage, attackedPlayer);
      if (actualDamage > 0) {
        attackedPlayer.getEffectiveAbilities().setHealth(
                attackedPlayer.getEffectiveAbilities().getHealth() - actualDamage);
        return List.of(attackingPlayer.getPlayerId(), "Hit!", actualDamage);
      } else {
        return List.of(attackingPlayer.getPlayerId(), "Hit!", 0);
      }
    } else {
      return List.of(attackingPlayer.getPlayerId(), "Miss!", 0);
    }
  }

  private void startRound(Player player1, Player player2) {
    int round = 1;
    do {
      roundResult.put(round, attack(player1, player2));
      round++;
      roundResult.put(round, attack(player2, player1));
      round++;
    }
    while (player2.getEffectiveAbilities().getHealth() > 0
            && player1.getEffectiveAbilities().getHealth() > 0 && round <= 100);
  }

  private void startRoundMirror(Player player1, Player player2) {
    int round = 1;
    do {
      roundResult.put(round, attackMirror(player1, player2));
      round++;
      roundResult.put(round, attackMirror(player2, player1));
      round++;
    }
    while (player2.getEffectiveAbilities().getHealth() > 0
            && player1.getEffectiveAbilities().getHealth() > 0 && round <= 100);
  }

  private int calPotentialStrikingDamage(Player attackingPlayer) throws IllegalArgumentException {
    List<Weapons> weaponsList = attackingPlayer.getPlayerWeapon();
    int weaponDamage;
    int ability = 0;
    if (weaponsList.size() == 2) {
      weaponDamage = randomGen.weaponRange(weaponsList.get(randomGen.random0To1()), ability);
    } else if (weaponsList.size() == 1) {
      if (weaponsList.get(0).getWeaponType().equals("Two Handed Swords")) {
        weaponDamage = randomGen.weaponRange(weaponsList.get(0),
                attackingPlayer.getEffectiveAbilities().getStrength());
      }
      else if (weaponsList.get(0).getWeaponType().equals("Flails")) {
        weaponDamage = randomGen.weaponRange(weaponsList.get(0),
                attackingPlayer.getEffectiveAbilities().getDexterity());
      }
      else {
        weaponDamage = randomGen.weaponRange(weaponsList.get(0), 0);
      }
    }
    else {
      throw new IllegalArgumentException("Player should have a weapon!");
    }

    return attackingPlayer.getEffectiveAbilities().getStrength() + weaponDamage;
  }

  private int calPotentialStrikingDamageMirror(Player attackingPlayer) throws
          IllegalArgumentException {
    List<Weapons> weaponsList = attackingPlayer.getPlayerWeapon();
    int weaponDamage;
    int ability = 0;
    if (weaponsList.size() == 2) {
      weaponDamage = randomGen.weaponRange(weaponsList.get(randomGen.random0To1()), ability);
    }
    else if (weaponsList.size() == 1) {
      if (weaponsList.get(0).getWeaponType().equals("Two Handed Swords")
              || weaponsList.get(0).getWeaponType().equals("Flails")) {
        weaponDamage = 5;
      }
      else {
        weaponDamage = 7;
      }
    }
    else {
      throw new IllegalArgumentException("Player should have a weapon!");
    }
    return attackingPlayer.getEffectiveAbilities().getStrength() + weaponDamage;
  }

  private int calActualDamage(int potentialStrikingDamage, Player attackedPlayer) {
    return potentialStrikingDamage - attackedPlayer.getEffectiveAbilities().getConstitution();

  }

}
