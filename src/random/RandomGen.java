package random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import BattleGear.Gears;

public class RandomGen extends Random {

//  public RandomGen() {
//    //    this.rand = rand;
//  }
//
//  public RandomGen(int ...random) {
//    //    this.rand = rand;
//  }

  public int roll6(){
    return 2 + nextInt(5);
  }

  public int random4(){
    return 1 + nextInt(4);
  }

  public String randomPotion() throws IllegalArgumentException{
    switch (random4()) {
      case 1:
        return "Strength";
      case 2:
        return "Constitution";
      case 3:
        return "Dexterity";
      case 4:
        return "Charisma";
      default:
        throw new IllegalArgumentException("Ability not found! Choose number 1-4");
    }
  }

  public List<List<Gears>> randomItems(List<Gears> ogBag){
    List<Gears> bag = randomNegatives(ogBag);
    List<Gears> gearsList1 = new ArrayList<>();
    List<Gears> gearsList2 = new ArrayList<>();
    for (int i = bag.size();bag.size()>42;i--)
    {
      gearsList1.add(bag.remove(nextInt(i)));
    }
    for (int i = bag.size();bag.size()>22;i--)
    {
      gearsList2.add(bag.remove(nextInt(i)));
    }
//    System.out.println(gearsList1);
//    System.out.println(gearsList2);
    return List.of(gearsList1,gearsList2);
  }


  private List<Gears> randomNegatives(List<Gears> bag){

    List<Gears> updated_bag = new ArrayList<>();
    for (int i = bag.size();bag.size()>49;i--)
    { int x = nextInt(i);
      bag.get(x).setGearValue();
      updated_bag.add(bag.remove(x));
    }
    updated_bag.addAll(bag);
    return updated_bag;

  }


}

