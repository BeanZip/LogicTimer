package org.example;

import Components.AnalogClock;
import Components.BasicFunctions;
import Components.DigitalClock;
import com.formdev.flatlaf.FlatLightLaf;

class Main{
 public static void main(String[] args){
  FlatLightLaf.setup();
  ClockType clockType = new ClockType();
  ClockType.ClockTypeA Clock= new ClockType.ClockTypeA();
  Clock.Startuo();
 }
}