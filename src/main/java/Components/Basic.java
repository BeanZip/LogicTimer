package Components;

import javax.swing.*;
import java.awt.*;
import java.net.URI;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkMediumIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGruvboxDarkSoftIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;

public class Basic {
    public static class frame extends JFrame implements BasicFunctions.window {
        static JFrame frame = new JFrame("Logic Timer");
        @Override
        public void InitWindow(int screenwidth,int screenheight) {
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
        JMenu View = new JMenu("View Mode");

        JMenuItem Digital = new JMenuItem("Digital Clock");
        JMenuItem Analog = new JMenuItem("Analog Clock");

        JMenuItem git = new JMenuItem("GitHub");
        JMenuItem tut = new JMenuItem("How To Use");

        JMenu Git = new JMenu("GitHub Colors");
        JMenuItem GitL = new JMenuItem("GitHub Light");
        JMenuItem GitD = new JMenuItem("GitHub Dark");

        JMenu bas = new JMenu("Basic Themes");
        JMenuItem light = new JMenuItem("Light");
        JMenuItem dark = new JMenuItem("Dark");

        JMenu gruv = new JMenu("Gruvbox Themes");
        JMenuItem GruvboxLight = new JMenuItem("GruvBox Soft");
        JMenuItem GruvBoxNormal = new JMenuItem("Gruvbox Medium");
        JMenuItem GruvBoxHard = new JMenuItem("Gruvbox Hard");


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
            GruvBoxHard.addActionListener(e ->{
                FlatGruvboxDarkSoftIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(frame);
            });
            GruvBoxNormal.addActionListener(e ->{
                FlatGruvboxDarkMediumIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(frame);
            });
            GruvboxLight.addActionListener(e ->{
                FlatGruvboxDarkSoftIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(frame);
            });
            light.addActionListener(e ->{
                FlatLightLaf.setup();
                SwingUtilities.updateComponentTreeUI(frame);
            });
            dark.addActionListener(e->{
              FlatLightLaf.setup();
              SwingUtilities.updateComponentTreeUI(frame);
            });
            GitL.addActionListener(e ->{
                FlatGitHubIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(frame);
            });
            GitD.addActionListener(e ->{
                FlatGitHubDarkIJTheme.setup();
                SwingUtilities.updateComponentTreeUI(frame);
            });
            dark.addActionListener(e ->{
                FlatDarkLaf.setup();
                SwingUtilities.updateComponentTreeUI(frame);
            });
        }

        @Override
        public void frameaddition() {
            frame.setJMenuBar(menuBar);
            menuBar.add(sel);
            menuBar.add(op);
            sel.add(git);
            sel.add(tut);
            op.add(Theme);
            op.add(View);
            View.add(Analog);
            View.add(Digital);
            Theme.add(gruv);
            gruv.add(GruvBoxHard);
            gruv.add(GruvBoxNormal);
            gruv.add(GruvboxLight);
            Theme.add(bas);
            bas.add(light);
            bas.add(dark);
            Theme.add(Git);
            Git.add(GitL);
            Git.add(GitD);
        }
    }
}
