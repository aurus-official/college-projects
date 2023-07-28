package modules.superclass;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CFrame extends JFrame {
    private final Color BG_COLOR = new Color(35, 36, 35);
    public final Color TXT_COLOR = new Color(247, 255, 247);
    public Font txtFont;
    private int resolution[] = { 900, 600 };

    public CFrame() {
        setLayout(null);
        setVisible(true);
        setSize(resolution[0], resolution[1]);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(BG_COLOR);
        setLocation(200, 100);
        setResizable(false);
    }

    public void setResolution(int resolution[]) {
        this.resolution = resolution;
    }
}
