import org.junit.Before;
import org.junit.Test;

import PlayerInfo.Abilities;

import static org.junit.Assert.assertEquals;


public class AbilitiesTest {

  Abilities ab= new Abilities();;
  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void getStrength() {
  }

  @Test
  public void getConstitution() {
  }

  @Test
  public void getDexterity() {
  }

  @Test
  public void getCharisma() {
  }

  @Test
  public void testGetValue() {

    for(int i =0;i<10;i++){
      System.out.println(ab.getValue());
    }

  }
}