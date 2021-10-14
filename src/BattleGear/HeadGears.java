package BattleGear;

public class HeadGears extends AbstractGear {

public HeadGears(String gearName, int gearValue) {
        super("Head Gear", gearName,"Constitution",gearValue);
        }

protected int compareToHeadGears(Gears o) {
        return 0;
        }

@Override
public int compareTo(Gears o) {
        AbstractGear g = (AbstractGear) o;
        if (g.compareToHeadGears(this) == 0) {
        return this.getGearName().compareTo(g.getGearName());
        } else {
        return -1;
        }
        }


//  @Override
//  public int compareTo(Gears g) {
//    List<Gears> orderedGears = new ArrayList<>();
//    for (Gears gear : playerGears){
//      if(gear.getGearType() == "Head Gear"){
//        orderedGears.add(gear);
//        if(orderedGears.get(orderedGears.size() - 1).compareTo())
//          gear.getGearName()
//      }
//    }
//  }

        }
