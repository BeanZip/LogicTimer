package org.example;

import Components.BasicFunctions;
import Components.DigitalClock;
import com.formdev.flatlaf.FlatLightLaf;

class Main extends DigitalClock{
 public static void main(String[] args){
  FlatLightLaf.setup();
  DigitalClock digitalClock = new DigitalClock();
  digitalClock.InitWindow(500,300);
  digitalClock.interactable();
  digitalClock.frameaddition();
  digitalClock.setup();
  digitalClock.SetVisible();
 }
}