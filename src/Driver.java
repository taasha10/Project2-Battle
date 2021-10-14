import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import PlayerInfo.Player;

public class Driver {

  /**
   * Driver function to run the program and works as an interface/view for the user.
   * @param args Command line arguments
   */
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("********************************");
    System.out.println();
    System.out.println("Welcome to the game of Battle!");
    System.out.println();
    System.out.println("********************************");
    BattleLogic battleLogic = new BattleLogic();
    System.out.println("Ready to Create Players!");
    System.out.println("--------------------------------");
    List<Player> players = battleLogic.createPlayer();
    System.out.println("Player 1 :" + players.get(0).getAbilities());
    System.out.println("Player 2 :" + players.get(1).getAbilities());

    do{
    System.out.println("--------------------------------");
    System.out.println("Players Created! Ready to Equip and choose Weapon!");
    System.out.println("--------------------------------");
    battleLogic.equipPlayer();
      int playerHealth1 = players.get(0).getEffectiveAbilities().getHealth();
      int playerHealth2 = players.get(1).getEffectiveAbilities().getHealth();
    battleLogic.callRequestWeaponFromArmory();
    System.out.println("--------------------------------");
    System.out.println("Player ready for the battle!");
    System.out.println("--------------------------------");
    Map playerDescriptionMap = new TreeMap();
    playerDescriptionMap =  battleLogic.descPlayerBeforeBattle();
    for(Object o :playerDescriptionMap.keySet()){
      System.out.println(playerDescriptionMap.get(o));
    }

    System.out.println("Player 1 Health:" + playerHealth1);
    System.out.println("Player 2 Health:" + playerHealth2);

    System.out.println("--------------------------------");
    System.out.println("Battle Started!");
    System.out.println("--------------------------------");
    System.out.println("Battle Round Result: " + battleLogic.startBattle());
    System.out.println("--------------------------------");
    System.out.println("Battle Result: ");
    if (players.get(0).getEffectiveAbilities().getHealth() > 0
            && players.get(1).getEffectiveAbilities().getHealth()<=0) {
      System.out.println(players.get(0).getPlayerId()+" won!");
    } else if (players.get(1).getEffectiveAbilities().getHealth() > 0
            && players.get(0).getEffectiveAbilities().getHealth()<=0) {
      System.out.println(players.get(1).getPlayerId()+" won!");
    } else {
      System.out.println("It's a draw!");
    }
      System.out.println("Player 1 Health:" + players.get(0).getEffectiveAbilities().getHealth());
      System.out.println("Player 2 Health:" + players.get(1).getEffectiveAbilities().getHealth());

    System.out.println("--------------------------------");
    System.out.println("Do you want a rematch? ");
    System.out.println("--------------------------------");
    if (sc.next().equals("Yes")){
      System.out.println("--------------------------------");
      System.out.println("Players getting ready for a rematch... ");
      System.out.println("--------------------------------");
      players.get(0).getEffectiveAbilities().setHealth(playerHealth1);
      players.get(1).getEffectiveAbilities().setHealth(playerHealth2);
    }
      else{
        System.out.println("--------------------------------");
        System.out.println("Ending the battle! Goodbye! ");
        System.out.println("--------------------------------");
        break;
      }
  }while(true);
  }
}
