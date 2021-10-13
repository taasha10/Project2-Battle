package BattleGear;

import java.util.ArrayList;
import java.util.List;

public class GearObjectsFactory {

  private Gears getGear(String gearType, String gearName, int... gearValue){
    if(gearType=="Head Gear"){

      return new HeadGears(gearName,gearValue[0]);
    }

    else if(gearType=="Potion"){
      return new Potions(gearName,gearValue[0]);
    }

    else if(gearType=="Belt"){
      return new Belts(gearName,gearValue);
    }

    else if(gearType=="Foot Wear"){
      return new Footwear(gearName,gearValue[0]);
    }

    else{
      return null;
    }
  }

 // Source : https://goldensun.fandom.com/wiki/List_of_Basic_Headgear
 public List<Gears> createGear()
 {
   List<Gears> gearsList = new ArrayList<>();
   Gears headGear1 = getGear("Head Gear","Leather Cap",1);
   gearsList.add(headGear1);
   Gears headGear2 = getGear("Head Gear","Wooden Cap",2);
   gearsList.add(headGear2);
   Gears headGear3 = getGear("Head Gear","Lucky Cap",3);
   gearsList.add(headGear3);
   Gears headGear4 = getGear("Head Gear","Lure Cap",4);
   gearsList.add(headGear4);
   Gears headGear5 = getGear("Head Gear","Prophet's Hat",5);
   gearsList.add(headGear5);
   Gears headGear6 = getGear("Head Gear","Ninja Hood",7);
   gearsList.add(headGear6);
   Gears headGear7 = getGear("Head Gear","Floating Crown",9);
   gearsList.add(headGear7);
   Gears headGear8 = getGear("Head Gear","Crown of Jewels",10);
   gearsList.add(headGear8);
   Gears headGear9 = getGear("Head Gear","Thunder Crown",11);
   gearsList.add(headGear9);
   Gears headGear10 = getGear("Head Gear","Crown of God",13);
   gearsList.add(headGear10);

   //Source :https://www.fantasynamegenerators.com/potion-names.php
   Gears potion1 = getGear("Potion","Tonic of Foresight",1);
   gearsList.add(potion1);
   Gears potion2 = getGear("Potion","Elixir of Flight",1);
   gearsList.add(potion2);
   Gears potion3 = getGear("Potion","Flask of Honesty",1);
   gearsList.add(potion3);
   Gears potion4 = getGear("Potion","Potion of Focus",2);
   gearsList.add(potion4);
   Gears potion5 = getGear("Potion","Vial of the Seer",2);
   gearsList.add(potion5);
   Gears potion6 = getGear("Potion","Tonic of Foresight II",3);
   gearsList.add(potion6);
   Gears potion7 = getGear("Potion","Vial of Pleasure",3);
   gearsList.add(potion7);
   Gears potion8 = getGear("Potion","Vial of Thunder",4);
   gearsList.add(potion8);
   Gears potion9 = getGear("Potion","Tonic of Curing",4);
   gearsList.add(potion9);
   Gears potion10 = getGear("Potion","Elixir of Holy Protection",5);
   gearsList.add(potion10);
   Gears potion11 = getGear("Potion","Tonic of Foresight",5);
   gearsList.add(potion11);
   Gears potion12 = getGear("Potion","Elixir of Flight II",6);
   gearsList.add(potion12);
   Gears potion13 = getGear("Potion","Flask of Honesty II",6);
   gearsList.add(potion13);
   Gears potion14 = getGear("Potion","Potion of Focus II",7);
   gearsList.add(potion14);
   Gears potion15 = getGear("Potion","Vial of the Seer II",7);
   gearsList.add(potion15);
   Gears potion16 = getGear("Potion","Tonic of Foresight III",8);
   gearsList.add(potion16);
   Gears potion17 = getGear("Potion","Vial of Pleasure II ",9);
   gearsList.add(potion17);
   Gears potion18 = getGear("Potion","Vial of Thunder II",10);
   gearsList.add(potion18);
   Gears potion19 = getGear("Potion","Tonic of Curing II",11);
   gearsList.add(potion19);
   Gears potion20 = getGear("Potion","Elixir of Holy Protection II",11);
   gearsList.add(potion20);
   Gears potion21 = getGear("Potion","Elixir of Holy Protection III",13);
   gearsList.add(potion21);

   Gears belt1 = getGear("Belt","Sash of Twisted Fortunes");
   gearsList.add(belt1);
   Gears belt2 = getGear("Belt","Strap of Infinite Illusions",1);
   gearsList.add(belt2);
   Gears belt3 = getGear("Belt","Dragon's Silk Waistband",1,2);
   gearsList.add(belt3);
   Gears belt4 = getGear("Belt","Wicked Belt of the Dead",2);
   gearsList.add(belt4);
   Gears belt5 = getGear("Belt","Belt of Divine Kings",3);
   gearsList.add(belt5);
   Gears belt6 = getGear("Belt","Cord of Unholy Souls");
   gearsList.add(belt6);
   Gears belt7 = getGear("Belt","Frost Leather Girdle",3,4);
   gearsList.add(belt7);
   Gears belt8 = getGear("Belt","Pride's Girdle of the Princess",4);
   gearsList.add(belt8);
   Gears belt9 = getGear("Belt","Champion Hide Sash");
   gearsList.add(belt9);
   Gears belt10 = getGear("Belt","Promised Strap of Suffering's End",5);
   gearsList.add(belt10);
   Gears belt11 = getGear("Belt","Sash of Twisted Fortunes II",5,6);
   gearsList.add(belt11);
   Gears belt12= getGear("Belt","Strap of Infinite Illusions II",6);
   gearsList.add(belt12);
   Gears belt13= getGear("Belt","Dragon's Silk Waistband II",5,7);
   gearsList.add(belt13);
   Gears belt14 = getGear("Belt","Wicked Belt of the Dead II",7);
   gearsList.add(belt14);
   Gears belt15 = getGear("Belt","Belt of Divine Kings II");
   gearsList.add(belt15);
   Gears belt16 = getGear("Belt","Cord of Unholy Souls II",4,8);
   gearsList.add(belt16);
   Gears belt17 = getGear("Belt","Frost Leather Girdle II",9);
   gearsList.add(belt17);
   Gears belt18 = getGear("Belt","Pride's Girdle of the Princess II",9);
   gearsList.add(belt18);
   Gears belt19 = getGear("Belt","Champion Hide Sash II",3,10);
   gearsList.add(belt19);
   Gears belt20 = getGear("Belt","Promised Strap of Suffering's End II",10);
   gearsList.add(belt20);
   Gears belt21 = getGear("Belt","Belt of the champions",2,11);
   gearsList.add(belt21);

   Gears footWear1 = getGear("Foot Wear","Faithful Silver Feet",1);
   gearsList.add(footWear1);
   Gears footWear2 = getGear("Foot Wear","Padded Sprinters",2);
   gearsList.add(footWear2);
   Gears footWear3 = getGear("Foot Wear","Prime Boots of Kings",3);
   gearsList.add(footWear3);
   Gears footWear4 = getGear("Foot Wear","Primal Hide Footpads",4);
   gearsList.add(footWear4);
   Gears footWear5 = getGear("Foot Wear","Brutal Silk Sprinters",5);
   gearsList.add(footWear5);
   Gears footWear6 = getGear("Foot Wear","Walkers of Lost Fires",7);
   gearsList.add(footWear6);
   Gears footWear7 = getGear("Foot Wear","Reforged Mail Feet",9);
   gearsList.add(footWear7);
   Gears footWear8 = getGear("Foot Wear","Firesoul Treads of Ice",11);
   gearsList.add(footWear8);
   Gears footWear9 = getGear("Foot Wear","Warboots of Frozen Warlords",11);
   gearsList.add(footWear9);
   Gears footWear10 = getGear("Foot Wear","Conqueror's Warboots of Immortality",13);
   gearsList.add(footWear10);

   return gearsList;
 }

}
