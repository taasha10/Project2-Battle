package BattleGear;

import static java.lang.Math.abs;

public class Belts extends AbstractGear {


  BeltSize beltSize = null;
  public Belts( String gearName, int... gearValue) {

    super("Belt", gearName, gearValue);
    if(gearValue != null && gearValue.length==2 )
    { setBeltSize(Math.max(abs(gearValue[0]),abs(gearValue[1])));
    }
    else if(gearValue != null && gearValue.length==1 )
    { setBeltSize(abs(gearValue[0]));
    }
    else if(gearValue != null && gearValue.length==0){
      setBeltSize(0);
    }
  }

  private void setBeltSize(int i){

    if (i < 5){
      beltSize = BeltSize.small;
    }
    else if (i < 8){
      beltSize = BeltSize.medium;
    }
    else if (i <=15){
      beltSize = BeltSize.large;
    }
  }

  public BeltSize getBeltSize() {
    return beltSize;
  }
}
