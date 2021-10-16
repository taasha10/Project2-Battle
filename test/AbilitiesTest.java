import org.junit.Before;
import org.junit.Test;

import player.info.Abilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Class to test the Abilities class and its public methods.
 */
public class AbilitiesTest {

  Abilities ab;
  Abilities abTestMin;
  Abilities abTestMax;

  @Before
  public void setUp() {
    ab = new Abilities();
    abTestMin = createAbilities(2);
    abTestMax = createAbilities(6);
  }

  private Abilities createAbilities(int i) {
    return new Abilities(i);
  }


  @Test
  public void testGetStrength() {
    assertEquals(6, abTestMin.getStrength());
    assertEquals(18, abTestMax.getStrength());
  }

  @Test
  public void testGetConstitution() {
    assertEquals(6, abTestMin.getConstitution());
    assertEquals(18, abTestMax.getConstitution());
  }

  @Test
  public void testGetDexterity() {
    assertEquals(6, abTestMin.getDexterity());
    assertEquals(18, abTestMax.getDexterity());
  }

  @Test
  public void testGetCharisma() {
    assertEquals(6, abTestMin.getCharisma());
    assertEquals(18, abTestMax.getCharisma());
  }

  @Test
  public void testGetValue() {
    for (int i = 0; i < 1000000; i++) {
      assertFalse(ab.getValue() > 18);
      assertFalse(ab.getValue() < 6);
    }
  }

  @Test
  public void testGetHealth() {
    assertEquals(24, abTestMin.getHealth());
    assertEquals(72, abTestMax.getHealth());
  }

  @Test
  public void testToString() {
    assertEquals("Abilities{strength=18, constitution=18, dexterity=18, charisma=18}",
            abTestMax.toString());
  }
}