package org.example;

import Components.AnalogClock;
import Components.BasicFunctions;
import Components.DigitalClock;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;

class Main{
 public static void main(String[] args){
  FlatLightLaf.setup();
  ClockType clockType = new ClockType();
  ClockType.ClockTypeA Clock= new ClockType.ClockTypeA();
  AnalogClock analogClock = new AnalogClock();
  Status status = new Status();
  try {
   analogClock.InitWindow(400, 400);
   analogClock.frameaddition();
   analogClock.interactable();
   analogClock.interactable2();
   analogClock.setup();
   analogClock.setVisible(true);
  } catch(IllegalArgumentException e){
     Status.check(e);
 }
}
}