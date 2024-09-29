package org.example;

import Components.AnalogClock;
import com.formdev.flatlaf.FlatLightLaf;
import Components.Status;

class Main{
    private static String[] args;

 public static String[] getArgs() {
  return args;
 }

 public static void setArgs(String[] args) {
  Main.args = args;
 }

 public static void main(String[] args) {
  Main.args = args;
  FlatLightLaf.setup();
  ClockType clockType = new ClockType();
  ClockType.ClockTypeA Clock = new ClockType.ClockTypeA();
  AnalogClock analogClock = new AnalogClock();
  try {
   analogClock.InitWindow(400, 400);
   analogClock.frameaddition();
   analogClock.interactable();
   analogClock.interactable2();
   analogClock.setup();
   analogClock.setVisible(true);
  } catch (IllegalArgumentException e) {
   Status.check(e);

  }
 }
}