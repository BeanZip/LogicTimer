package Components

import javax.swing.JFrame
import javax.swing.JOptionPane

class Status{
    static int check(IllegalArgumentException Error){
        JFrame frame = new JFrame("Initialization Error Message!")
        frame.setSize(400,400)
        JOptionPane.showMessageDialog(frame,"Window Could Not Initialize" + Error.printStackTrace())
        Thread.start{
            Thread.sleep(2000)
            frame.dispose()
        }
        return 1
    }
}
