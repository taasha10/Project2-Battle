package BattleGear;

public enum BeltSize {
  small(1), medium(2), large(4);

  private final int units;

  BeltSize(int units) {
    this.units = units;
  }

  /**
   * to obtain the unit of a belt.
   * @return unit
   */
  public int getUnits() {
    return units;
  }
}