package PlayerInfo;

import java.util.List;

import BattleGear.Gears;

public class Player {

  String playerId;
  Abilities abilities;
  Abilities effectiveAbilities;
  List<Gears> playerGears;

  public String getPlayerId() {
    return playerId;
  }

  public List<Gears> getPlayerGears() {
    return playerGears;
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

    System.out.println(ability+":::"+gearValue);
    switch (ability) {
      case "Strength": effectiveAbilities.setStrength(effectiveAbilities.getStrength()
              +gearValue);
      break;
      case "Constitution": effectiveAbilities.setConstitution(effectiveAbilities.getConstitution()
              +gearValue);
      break;
      case "Dexterity": effectiveAbilities.setDexterity(effectiveAbilities.getDexterity()
              +gearValue);
      break;
      case "Charisma": effectiveAbilities.setCharisma(effectiveAbilities.getCharisma()
              +gearValue);
      break;
    }
  }

//  public int calStrikingPower(){
//    abilities.getStrength() +
//  }

  @Override
  public String toString() {
    return "Player{" +
            "playerId='" + playerId + '\'' +
            ", abilities=" + abilities +
            '}';
  }
}
