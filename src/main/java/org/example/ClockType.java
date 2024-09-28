package org.example;

import Components.AnalogClock;
import Components.Basic;
import Components.DigitalClock;

public class ClockType{
    static public class ClockTypeA extends Basic.menu{
     DigitalClock digitalClock = new DigitalClock();
     AnalogClock analogClock = new AnalogClock();
     public void Startuo(){
         InitWindow(400,400);
         frameaddition();
         interactable();
         analogClock.setup();
         analogClock.interactable2();
         digitalClock.setup();
         digitalClock.interactable();
         setVisible(true);
     }
    }
}
