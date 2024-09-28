package org.example;

import Components.BasicFunctions;
import Components.DigitalClock;

class Main extends DigitalClock{
 public static void main(String[] args){
  DigitalClock digitalClock = new DigitalClock();
  digitalClock.InitWindow();
  digitalClock.interactable();
  digitalClock.frameaddition();
  digitalClock.setup();
  digitalClock.SetVisible();
 }
}