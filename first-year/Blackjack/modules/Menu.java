package modules;

import java.awt.*;
import java.awt.event.*;
import modules.Play;
import modules.superclass.CFrame;

import javax.swing.*;

public class Menu {
    final String buttonTextList[] = { "Play", "Credits", "Settings", "Exit" };
    // final Color BG_COLOR = new Color(35, 36, 35);
    // final Color TXT_COLOR = new Color(247, 255, 247);
    // Font txtFont;
    CFrame menuFrame;

    public Menu() {
        this.setupFrame();

        // GraphicsEnvironment environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        // GraphicsDevice device = environment.getDefaultScreenDevice();
        // device.setFullScreenWindow(menuFrame);
    }

    private void setupFrame() {
        menuFrame = new CFrame();
        this.setupTitle();
        this.setupMenuButton();
    }

    private void setupTitle() {
        menuFrame.txtFont = new Font(Font.MONOSPACED, Font.PLAIN, 50);
        JLabel title = new JLabel("Welcome to Blackjack!", JLabel.CENTER);
        title.setBounds(0, 50, 900, 80);
        title.setFont(menuFrame.txtFont);
        title.setForeground(menuFrame.TXT_COLOR);
        menuFrame.add(title);
    }

    private void setupMenuButton() {
        Font txtFont = new Font(Font.MONOSPACED, Font.PLAIN, 25);
        int yOffset = 0;

        for (String i : buttonTextList) {
            Button menuButton = new Button(i);
            menuButton.setFont(txtFont);
            menuButton.setForeground(menuFrame.TXT_COLOR);
            menuButton.setBounds(350, 200 + yOffset, 200, 60);

            switch(i) {
                case "Play":
                    menuButton.addActionListener((ActionEvent e) -> {
                        Point coords = menuFrame.getLocation();
                        new Play(coords.x, coords.y);
                        menuFrame.dispose();
                    });
                    break;
                case "Credits":
                    menuButton.addActionListener((ActionEvent e) -> {
                    });
                    break;
                case "Settings":
                    menuButton.addActionListener((ActionEvent e) -> {
                    });
                    break;
                case "Exit":
                    menuButton.addActionListener((ActionEvent e) -> {
                        menuFrame.dispose();
                    });
                    break;
            }
            yOffset += 85;
            menuFrame.add(menuButton);
        }
    }
}
