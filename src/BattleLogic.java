import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import BattleGear.GearObjectsFactory;
import BattleGear.Gears;
import BattleWeapons.Weapons;
import PlayerInfo.Player;
import random.RandomGen;

public class BattleLogic {

  Player player1,player2;
  RandomGen randomGen;
  Map<Integer,List> roundResult;

  public BattleLogic() {
    player1 = new Player(1);
    player2 = new Player(2);
    randomGen = new RandomGen();
    roundResult = new TreeMap<>();
  }

  public Player getPlayer1() {
    return player1;
  }

  public Player getPlayer2() {
    return player2;
  }

  public List<Player> createPlayer(){

    List<Player> listOfPlayers = new ArrayList<>();
    listOfPlayers.add(getPlayer1());
    listOfPlayers.add(getPlayer2());
    return listOfPlayers;
  }

  public void equipPlayer(){

    GearObjectsFactory gearObjectsFactory = new GearObjectsFactory();
    List<Gears> bag = gearObjectsFactory.createGear();
    List<List<Gears>> assignItems = randomGen.randomItems(bag);
    player1.setPlayerGears(assignItemsToPlayer(assignItems.get(0)));
    player2.setPlayerGears(assignItemsToPlayer(assignItems.get(1)));
    player1.calEffectiveAbilities();
    player2.calEffectiveAbilities();

  }

  private List<Gears> assignItemsToPlayer(List<Gears> gearsList){
    boolean headGear = false,footWear = false;
    List<Gears> finalGears = new ArrayList<>();
    int unit = 0;

    for (int i = 0; i<20 ;i++)
    {
      Gears gear = gearsList.get(i);
      if(gear.getGearType() == "Head Gear" && !headGear){
        headGear = true;
        finalGears.add(gear);
      }
      else if(gear.getGearType() == "Foot Wear" && !footWear){
        footWear = true;
        finalGears.add(gear);
      }
      else if((gear.getGearType() == "Foot Wear" && footWear) ||
              (gear.getGearType() == "Head Gear" && headGear)){
        continue;
      }
      else if(gear.getGearType() == "Belt"){

        unit = unit + gear.getBeltSize().getUnits();
        if(unit<=10){
          finalGears.add(gear);
        }
        else{
          unit = unit - gear.getBeltSize().getUnits();
        }
      }
      else if(gear.getGearType() == "Potion"){
        finalGears.add(gear);
      }
    }
    return finalGears;
  }

  private void requestWeaponFromArmory(Player p){
    Weapons selectedWeapon = randomGen.randomSelectionOfWeapon();
    if(selectedWeapon.getWeaponType() == "Katanas"){
      Weapons selectedWeapon2 = randomGen.randomSelectionOfWeapon();
      if(selectedWeapon2.getWeaponType() == "Katanas"){
        p.setPlayerWeapon(List.of(selectedWeapon,selectedWeapon2));
      }
    }
    p.setPlayerWeapon(Collections.singletonList(selectedWeapon));
  }

  public void callRequestWeaponFromArmory(){
    requestWeaponFromArmory(getPlayer1());
    requestWeaponFromArmory(getPlayer2());
  }

  /**
   * To provide a complete description of players that will enter the arena.
   * @return Map of player and it's attributes.
   */
  public Map<String,Map<String,String>> descPlayerBeforeBattle(){
    Map<String,Map<String,String>> details = new TreeMap<>();
    Map<String,String> detailsOfPlayer1 = new TreeMap<>();
    Map<String,String> detailsOfPlayer2 = new TreeMap<>();
    detailsOfPlayer1.put("Gears :",player1.getPlayerGears().toString());
    detailsOfPlayer1.put("Weapon :",player1.getPlayerWeapon().toString());
    detailsOfPlayer1.put("Effective Abilities :",player1.getEffectiveAbilities().toString());
    details.put("Player 1 :",detailsOfPlayer1);
    detailsOfPlayer2.put("Effective Abilities :",player2.getEffectiveAbilities().toString());
    detailsOfPlayer2.put("Gears :",player2.getPlayerGears().toString());
    detailsOfPlayer2.put("Weapon :",player2.getPlayerWeapon().toString());
    details.put("Player 2 :",detailsOfPlayer2);
    return details;
  }

  public Map<Integer, List> startBattle(){
    if(player1.getEffectiveAbilities().getCharisma() >= player2.getEffectiveAbilities().getCharisma())
    {
      startRound(player1,player2);
    }
    else{
      startRound(player2,player1);
    }
    return roundResult;
  }

  private List attack(Player attackingPlayer, Player attackedPlayer){

    if(attackingPlayer.calStrikingPower() > attackedPlayer.calAvoidanceAbility()){
      int potentialStrikingDamage = calPotentialStrikingDamage(attackingPlayer);
      int actualDamage = calActualDamage(potentialStrikingDamage,attackedPlayer);
      if(actualDamage > 0){
        attackedPlayer.getEffectiveAbilities().setHealth(
                attackedPlayer.getEffectiveAbilities().getHealth()-actualDamage);
        return List.of(attackingPlayer.getPlayerId(),"Hit!",actualDamage);
      }
      else{
        return List.of(attackingPlayer.getPlayerId(),"Hit!",0);
      }
    }
    else{
      return List.of(attackingPlayer.getPlayerId(),"Miss!",0);
    }
  }

  private void startRound(Player player1,Player player2){
    int round = 1;
    do {
      roundResult.put(round,attack(player1,player2));
      round++;
      roundResult.put(round,attack(player2,player1));
      round++;
    }while(player2.getEffectiveAbilities().getHealth()>0 &&
            player1.getEffectiveAbilities().getHealth()>0 && round<=1000);

  }

  private int calPotentialStrikingDamage(Player attackingPlayer) throws IllegalArgumentException{
    List<Weapons> weaponsList = attackingPlayer.getPlayerWeapon();
    int weaponDamage;
    int ability = 0;
    if(weaponsList.size() == 2){
      weaponDamage = randomGen.WeaponRange(weaponsList.get(randomGen.random0To1()),ability);
    }
    else if(weaponsList.size() == 1){
      if(weaponsList.get(0).getWeaponType() =="Two Handed Swords") {
        weaponDamage = randomGen.WeaponRange(weaponsList.get(0)
                ,attackingPlayer.getEffectiveAbilities().getStrength());
      }
      else if(weaponsList.get(0).getWeaponType() =="Flails") {
        weaponDamage = randomGen.WeaponRange(weaponsList.get(0)
                ,attackingPlayer.getEffectiveAbilities().getDexterity());
      }
      else {
        weaponDamage = randomGen.WeaponRange(weaponsList.get(0)
                ,0);
      }
    }
    else{
      throw new IllegalArgumentException("Player should have a weapon!");
    }

    return attackingPlayer.getEffectiveAbilities().getStrength() + weaponDamage;
  }

  private int calActualDamage(int potentialStrikingDamage,Player attackedPlayer){
   return potentialStrikingDamage - attackedPlayer.getEffectiveAbilities().getConstitution();

  }

}
