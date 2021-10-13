import org.junit.Before;
import org.junit.Test;

import BattleGear.GearObjectsFactory;
import random.RandomGen;


public class RandomGenTest {

  RandomGen r = new RandomGen();
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testRandomItems() {
    GearObjectsFactory gearObjectsFactory = new GearObjectsFactory();
    r.randomItems(gearObjectsFactory.createGear());
  }
}