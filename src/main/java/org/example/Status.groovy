package org.example

import javax.swing.JFrame
import javax.swing.JOptionPane

class Status{
    static def int check(IllegalArgumentException e){
        JFrame frame = new JFrame("Initialization Error Message!")
        frame.setSize(400,400)
        JOptionPane.showMessageDialog(frame,"Window Could Not Initialize" + e)
        Thread.start{
            Thread.sleep(2000)
            frame.dispose()
        }
        return 1
    }
}
