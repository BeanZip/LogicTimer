package org.example;

import Components.AnalogClock;
import Components.Basic;
import Components.DigitalClock;

public class ClockType{
    static public class ClockTypeA extends Basic.menu{
     DigitalClock digitalClock = new DigitalClock();
     AnalogClock analogClock = new AnalogClock();
     public void Startup(int screenwidth,int screenheight,boolean Displaying){
         InitWindow(screenwidth,screenheight);
         frameaddition();
         interactable();
         analogClock.setup();
         analogClock.interactable2();
         digitalClock.setup();
         digitalClock.interactable();
         setVisible(Displaying);
     }
    }
}
