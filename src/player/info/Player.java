package player.info;

import battlegear.Gears;
import battleweapons.Weapons;
import random.RandomGen;

import java.util.Collections;
import java.util.List;

/** Represents player and his abilities, his gears and his weapons along with the changed abilities
 * after acquiring them.
 *
 */
public class Player {

  private final String playerId;
  private final Abilities abilities;
  private Abilities effectiveAbilities;
  private List<Gears> playerGears;
  private List<Weapons> playerWeapon;
  private final RandomGen randomGen = new RandomGen();

  /**
   * Constructor for driver.
   * @param id of player.
   */
  public Player(int id) {
    this.playerId = "Player " + id;
    this.abilities = new Abilities();
    this.effectiveAbilities = new Abilities(abilities);
    playerGears = null;
  }

  /**
   * Constructor for testing.
   * @param id .
   * @param abilities .
   */
  public Player(int id, Abilities abilities) {
    this.playerId = "Player " + id;
    this.abilities = abilities;
    this.effectiveAbilities = new Abilities(abilities);
    playerGears = null;
  }

  public String getPlayerId() {
    return playerId;
  }

  /**
   *.
   * @return a copy of list of gears a player gets.
   */
  public List<Gears> getPlayerGears() {
    Collections.sort(playerGears);
    List<Gears> new_list = playerGears ;
    return new_list;

  }

  public void setPlayerGears(List<Gears> playerGears) {
    this.playerGears = playerGears;
  }

  public List<Weapons> getPlayerWeapon() {
    return playerWeapon;
  }

  public void setPlayerWeapon(List<Weapons> playerWeapon) {
    this.playerWeapon = playerWeapon;
  }

  public Abilities getAbilities() {
    return abilities;
  }

  public Abilities getEffectiveAbilities() {
    return effectiveAbilities;
  }

  /** Calculates ability after equipping gears.
   * .
   */
  public void calEffectiveAbilities() {
    for (Gears gears : playerGears) {
      if (gears.getGearType().equals("Belt")) {
        if (gears.getGearValue().size() == 2) {
          checkAbilityAffected(gears.getAbilityAffected(), gears.getGearValue().get(0));
          checkAbilityAffected(gears.getAbilityAffected1(), gears.getGearValue().get(1));
        } else if (gears.getGearValue().size() == 1) {
          checkAbilityAffected(gears.getAbilityAffected(), gears.getGearValue().get(0));
        }
      } else {
        checkAbilityAffected(gears.getAbilityAffected(), gears.getGearValue().get(0));
      }
    }

  }

  /** Calculates ability after equipping gears.
   * .
   *
   * @param ability of player affected by the gear.
   * @param gearValue gear affecting value.
   */
  public void calEffectiveAbilities(String ability, int gearValue) {
    for (Gears gears : playerGears) {
      checkAbilityAffected(ability, gearValue);
    }
  }

  private void checkAbilityAffected(String ability, int gearValue) throws IllegalArgumentException {

    int check;
    switch (ability) {
      case "Strength":
        check = effectiveAbilities.getStrength() + gearValue;
        if (check > 0) {
          effectiveAbilities.setStrength(check);
        }
        break;
      case "Constitution":
        check = effectiveAbilities.getConstitution() + gearValue;
        if (check > 0) {
          effectiveAbilities.setConstitution(check);
        }
        break;
      case "Dexterity":
        check = effectiveAbilities.getDexterity() + gearValue;
        if (check > 0) {
          effectiveAbilities.setDexterity(check);
        }
        break;
      case "Charisma":
        check = effectiveAbilities.getCharisma()
                + gearValue;
        if (check > 0) {
          effectiveAbilities.setCharisma(check);
        }
        break;
      default:
        throw new IllegalArgumentException("Wrong ability entered.");
    }
    effectiveAbilities.setHealth(effectiveAbilities.getStrength()
            + effectiveAbilities.getConstitution() + effectiveAbilities.getCharisma()
            + effectiveAbilities.getDexterity());
  }

  /** Calculates striking power. Striking power is the sum of the strength of the player, any of
   * the gear that adds (or substracts) from strength, and a random number between 1 and 10
   * (inclusive).
   *
   * @return striking power.
   */
  public int calStrikingPower() {
    //    System.out.println(playerId+strike);
    return effectiveAbilities.getStrength() + randomGen.random1To10();
  }

  /** Calculates striking power for testing.
   *
   * @param random between 1 and 10.
   * @return striking power.
   */
  public int calStrikingPower(int random) {
    return effectiveAbilities.getStrength() + random;
  }

  /** Calculates Avoidance Availability.Avoidance ability is the sum of the dexterity of the
   * player, any of the gear that adds (or subtracts) from dexterity, and a random number between
   * 1 and 6 (inclusive).
   *
   * @return Avoidance Availability.
   */
  public int calAvoidanceAbility() {
    //    System.out.println(playerId+avoid);
    return effectiveAbilities.getDexterity() + randomGen.random1To6();
  }

  /** Calculates Avoidance Availability for testing.
   *
   * @param random between 1 and 6.
   * @return Avoidance Availability
   */
  public int calAvoidanceAbility(int random) {
    return effectiveAbilities.getDexterity() + random;
  }

  @Override
  public String toString() {
    return "Player{" + "playerId='" + playerId + '\'' + ", abilities=" + abilities + '}';
  }

}
