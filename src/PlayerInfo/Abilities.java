package PlayerInfo;

import java.util.ArrayList;
import java.util.List;

import random.RandomGen;

import static java.util.Collections.min;


public class Abilities {

  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private int health;
  RandomGen rand = new RandomGen();

  public Abilities() {
    this.strength = getValue();
    this.constitution = getValue();
    this.dexterity = getValue();
    this.charisma = getValue();
    this.health = strength + constitution + dexterity + charisma;
  }

  public void setConstitution(int constitution) {
    this.constitution = constitution;
  }

  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }

  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public Abilities(Abilities ab) {
    this.strength = ab.strength;
    this.constitution = ab.constitution;
    this.dexterity = ab.dexterity;
    this.charisma = ab.charisma;
    this.health = ab.health;
  }

  public int getStrength() {
    return strength;
  }

  public int getConstitution() {
    return constitution;
  }

  public int getDexterity() {
    return dexterity;
  }

  public int getCharisma() {
    return charisma;
  }

  public int getHealth() {
    return health;
  }

  public int getValue() {
    List<Integer> roll = new ArrayList<>();
    int total = 0;
    for (int i=0;i<4;i++){
      roll.add(rand.roll6());
      total+= roll.get(i);
//      System.out.println("inside loop::"+roll.get(i));
    }
    return(total-min(roll));
  }

  @Override
  public String toString() {
    return "Abilities{" +
            "strength=" + strength +
            ", constitution=" + constitution +
            ", dexterity=" + dexterity +
            ", charisma=" + charisma +
            '}';
  }
}
