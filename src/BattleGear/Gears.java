package BattleGear;

import java.util.List;

public interface Gears extends Comparable<Gears> {

  String getGearType();
  String getGearName();
  List<Integer> getGearValue();
  String getAbilityAffected();
  String getAbilityAffected1();
  public BeltSize getBeltSize();
  public void setGearValue();
  public int compareTo(Gears o);
}
