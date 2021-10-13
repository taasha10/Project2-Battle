import java.util.List;

import PlayerInfo.Player;

public class Driver {

  /**
   * Driver function to run the program and works as an interface/view for the user.
   * @param args Command line arguments
   */
  public static void main(String[] args) {

    System.out.println("Welcome to the game of Battle!");
    BattleLogic battleLogic = new BattleLogic();
    List<Player> players = battleLogic.createPlayer();
    System.out.println("PlayerInfo.Player 1 :" + players.get(0).getAbilities().toString());
    System.out.println("PlayerInfo.Player 2 :" + players.get(1).getAbilities().toString());



  }
}
