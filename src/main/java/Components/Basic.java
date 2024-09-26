package Components;

import javax.swing.*;
import java.awt.*;
import java.net.URI;

public class Basic {
    public static class frame extends JFrame implements BasicFunctions.window {
        static JFrame frame = new JFrame("Logic Timer");
        int screenheight = 400;
        int screenwidth = 300;
        @Override
        public void InitWindow() {
         frame.setSize(screenwidth,screenheight);
        }

        @Override
        public void SetVisible() {
         frame.setVisible(true);
        }
    }

    public static class menu extends frame implements BasicFunctions{
        JMenuBar menuBar = new JMenuBar();
        JMenu sel = new JMenu("Help");
        JMenu op = new JMenu("Options");

        JMenu Theme = new JMenu("Theme");
        JMenu adjust = new JMenu("Adjust Size");

        JMenuItem git = new JMenuItem("GitHub");
        JMenuItem tut = new JMenuItem("How To Use");

        @Override
        public void interactable() {
            git.addActionListener(e ->{
                try {
                    Desktop desktop = java.awt.Desktop.getDesktop();
                    URI oURL = new URI("https://github.com/BeanZip");
                    desktop.browse(oURL);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            tut.addActionListener(e ->{
              JOptionPane.showMessageDialog(frame,"Switch Views, Set Time and Etc");
            });
        }

        @Override
        public void frameaddition() {
            sel.add(git);
            sel.add(tut);
        }
    }
}
