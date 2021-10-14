import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BattleLogicTest {

  BattleLogic battleLogic = new BattleLogic();
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void getPlayers1() {
  }

  @Test
  public void getPlayer2() {
  }

  @Test
  public void testCreatePlayer() {
    System.out.println(battleLogic.createPlayer());
  }


  @Test
  public void testEquipPlayer(){
    battleLogic.equipPlayer();
  }

  @Test
  public void testCallRequestWeaponFromArmory() {
    battleLogic.callRequestWeaponFromArmory();
  }
}

