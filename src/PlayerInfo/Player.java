package PlayerInfo;

import java.util.Collections;
import java.util.List;

import BattleGear.Gears;
import BattleWeapons.Weapons;
import random.RandomGen;

public class Player {

  String playerId;
  Abilities abilities;
  Abilities effectiveAbilities;
  List<Gears> playerGears;
  List<Weapons> playerWeapon;
  RandomGen randomGen = new RandomGen();

  public String getPlayerId() {
    return playerId;
  }

  public List<Gears> getPlayerGears() {
    Collections.sort(playerGears);
    return playerGears;

  }

  public List<Weapons> getPlayerWeapon() {
    return playerWeapon;
  }

  public Player(int id) {
    this.playerId = "Player " + id;
    this.abilities = new Abilities();
    this.effectiveAbilities = new Abilities(abilities);
    playerGears = null;
  }

  public Abilities getAbilities() {
    return abilities;
  }

  public Abilities getEffectiveAbilities() {
    return effectiveAbilities;
  }


  public void setPlayerGears(List<Gears> playerGears) {
    this.playerGears = playerGears;
  }

  public void setPlayerWeapon(List<Weapons> playerWeapon) {
    this.playerWeapon = playerWeapon;
  }

  public void calEffectiveAbilities() {
    for(Gears gears : playerGears){
      if(gears.getGearType()=="Belt"){
        if(gears.getGearValue().size()==2 )
        {
          checkAbilityAffected(gears.getAbilityAffected(),gears.getGearValue().get(0));
          checkAbilityAffected(gears.getAbilityAffected1(),gears.getGearValue().get(1));
        }
        else if(gears.getGearValue().size()==1) {
          {
            checkAbilityAffected(gears.getAbilityAffected(),gears.getGearValue().get(0));
          }
        }
      }
      else {
        checkAbilityAffected(gears.getAbilityAffected(),gears.getGearValue().get(0));
      }
    }

  }

  private void checkAbilityAffected(String ability,int gearValue){
    int check;
//    System.out.println(ability+":::"+gearValue);
    switch (ability) {
      case "Strength": check = effectiveAbilities.getStrength() + gearValue;
      if(check>0){effectiveAbilities.setStrength(check);}
      break;
      case "Constitution": check = effectiveAbilities.getConstitution() + gearValue;
        if(check>0){effectiveAbilities.setConstitution(check);}
      break;
      case "Dexterity": check = effectiveAbilities.getDexterity() + gearValue;
        if(check>0){effectiveAbilities.setDexterity(check);}
      break;
      case "Charisma": check = effectiveAbilities.getCharisma()
              +gearValue;
        if(check>0){effectiveAbilities.setCharisma(check);}
      break;
    }
    effectiveAbilities.setHealth(effectiveAbilities.getStrength()
            + effectiveAbilities.getConstitution() + effectiveAbilities.getCharisma()
            + effectiveAbilities.getDexterity());
  }

  public int calStrikingPower(){
    int strike = effectiveAbilities.getStrength() + randomGen.random1To10();
//    System.out.println(playerId+strike);
    return strike;
  }

  public int calAvoidanceAbility(){
    int avoid = effectiveAbilities.getDexterity() + randomGen.random1To6();
//    System.out.println(playerId+avoid);
    return avoid;
  }

  @Override
  public String toString() {
    return "Player{" +
            "playerId='" + playerId + '\'' +
            ", abilities=" + abilities +
            '}';
  }

}
