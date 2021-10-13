package BattleGear;

import java.util.List;

public interface Gears {

  String getGearType();
  String getGearName();
  List<Integer> getGearValue();
  String getAbilityAffected();
  String getAbilityAffected1();
  public BeltSize getBeltSize();
  public void setGearValue();
}
