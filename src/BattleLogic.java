import java.util.ArrayList;
import java.util.List;

import BattleGear.GearObjectsFactory;
import BattleGear.Gears;
import PlayerInfo.Player;
import random.RandomGen;

public class BattleLogic {

  Player player1,player2;

  public BattleLogic() {
    player1 = new Player(1);
    player2 = new Player(2);
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
    RandomGen randomGen = new RandomGen();
    List<List<Gears>> assignItems = randomGen.randomItems(bag);
    player1.setPlayerGears(assignItemsToPlayer(assignItems.get(0)));
    player2.setPlayerGears(assignItemsToPlayer(assignItems.get(1)));
    player1.calEffectiveAbilities();
//    System.out.println(player1.getPlayerGears());
    System.out.println(player1.getAbilities()+":::"+player1.getEffectiveAbilities());
    player2.calEffectiveAbilities();
//    System.out.println(player2.getPlayerGears());
    System.out.println(player2.getAbilities()+":::"+player2.getEffectiveAbilities());

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
//          System.out.println(gear.getGearName() + ":"+gear.getBeltSize().getUnits());
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
}
