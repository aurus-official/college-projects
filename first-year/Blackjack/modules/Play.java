package modules;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Play {
    Play(int x, int y) {
        JFrame playFrame = new JFrame("Play");
        playFrame.setSize(900, 600);
        playFrame.setVisible(true);
        playFrame.setLayout(null);
        playFrame.setResizable(false);
        playFrame.setLocation(x, y);
        playFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
