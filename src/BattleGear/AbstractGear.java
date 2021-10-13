package BattleGear;

import java.util.Collections;
import java.util.List;

import random.RandomGen;

public abstract class AbstractGear implements Gears{
  protected final String gearName;
  protected final String gearType;
  protected int[] gearValue;
  protected final String abilityAffected;
  protected final String abilityAffected1;
  RandomGen rg = new RandomGen();

  protected AbstractGear(String gearType, String gearName, int... gearValue) {
    this.gearName = gearName;
    this.gearType = gearType;
    this.gearValue = gearValue;

    if(gearValue.length==2 )
    {
      this.abilityAffected = rg.randomPotion();
      this.abilityAffected1 = rg.randomPotion();
    }
    else if(gearValue.length==1) {
      {
        this.abilityAffected = rg.randomPotion();
        this.abilityAffected1 = null;
      }
    }
    else {
      this.abilityAffected = this.abilityAffected1 = null;
    }

  }

  protected AbstractGear(String gearType, String gearName, String abilityAffected,int... gearValue) {
    this.gearName = gearName;
    this.gearType = gearType;
    this.gearValue = gearValue;
    this.abilityAffected = abilityAffected;
    this.abilityAffected1 = null;
  }

  @Override
  public String getGearType() {
    return gearType;
  }

  @Override
  public String getGearName() {
    return gearName;
  }

  @Override
  public List<Integer> getGearValue() {
    if(gearValue.length==2 )
    {
      return List.of(gearValue[0],gearValue[1]);
    }
    else if(gearValue.length==1) {
      {
        return Collections.singletonList(gearValue[0]);
      }
    }

    return List.of();
  }

  @Override
  public String getAbilityAffected() {
    return abilityAffected;
  }

  @Override
  public String getAbilityAffected1() {
    return abilityAffected1;
  }

  @Override
  public BeltSize getBeltSize() {
    return null;
  }

  @Override
  public void setGearValue() {

    if(gearValue.length==2 )
    {
      gearValue[0] *= -1;
      gearValue[1] *= -1;
    }
    else if(gearValue.length==1)
    { gearValue[0] *= -1;
    }

  }

  @Override
  public String toString() {
    return "Gear{" +
            "gearName='" + gearName + '\'' +
            ", gearType='" + gearType + '\'' +
            ", gearValue='" + getGearValue() + '\'' +
            ", beltSize='" + getBeltSize() + '\'' +
            '}';
  }
}
