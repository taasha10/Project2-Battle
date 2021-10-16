package player.info;

import static java.util.Collections.min;

import random.RandomGen;

import java.util.ArrayList;
import java.util.List;

/**
 * Denotes the 4 abilities.
 * Strength affects how effective the player is at striking their opponent.
 * Constitution affects how much damage a player can take when they are hit in battle.
 * Dexterity affects how effective the player is at avoiding a strike from their opponent.
 * Charisma affects how their opponent views them.
 * Health is the sum of all 4 abilities.
 */

public class Abilities {

  RandomGen rand = new RandomGen();
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private int health;

  /**
   * Class default constructor updating value using another method.
   */
  public Abilities() {
    this.strength = getValue();
    this.constitution = getValue();
    this.dexterity = getValue();
    this.charisma = getValue();
    this.health = strength + constitution + dexterity + charisma;
  }

  /**
   * Class copy constructor.
   * @param ab Abililies object.
   */
  public Abilities(Abilities ab) {
    this.strength = ab.strength;
    this.constitution = ab.constitution;
    this.dexterity = ab.dexterity;
    this.charisma = ab.charisma;
    this.health = ab.health;
  }

  /**
   * Class parameterized constructor for testing.
   * @param random a random integer to initiate all abilities.
   */
  public Abilities(int random) {
    this.strength = getValue(random);
    this.constitution = getValue(random);
    this.dexterity = getValue(random);
    this.charisma = getValue(random);
    this.health = strength + constitution + dexterity + charisma;
  }

  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getConstitution() {
    return constitution;
  }

  public void setConstitution(int constitution) {
    this.constitution = constitution;
  }

  public int getDexterity() {
    return dexterity;
  }

  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }

  public int getCharisma() {
    return charisma;
  }

  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  /**
   * Used to randomly roll a dice for different abilities.
   * @return random value between 6 to 18.
   */
  public int getValue() {
    List<Integer> roll = new ArrayList<>();
    int total = 0;
    for (int i = 0; i < 4; i++) {
      roll.add(rand.roll6());
      total += roll.get(i);
    }
    return (total - min(roll));
  }

  private int getValue(int random) {
    List<Integer> roll = new ArrayList<>();
    int total = 0;
    for (int i = 0; i < 4; i++) {
      roll.add(random);
      total += roll.get(i);
    }
    return (total - min(roll));
  }

  @Override
  public String toString() {
    return "Abilities{strength=" + strength + ", constitution=" + constitution + ", dexterity="
            + dexterity + ", charisma=" + charisma + '}';
  }
}
