package org.byramhills.bitethebacon.view.start;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.byramhills.bitethebacon.controller.FileSystem;
import org.byramhills.bitethebacon.controller.actions.PlayAction;
import org.byramhills.bitethebacon.view.Screen;

public class StartScreen extends Screen {
    private static final long serialVersionUID = 1314346261904481787L;
    
    private static final int TITLE_HEIGHT = 95;
    
    private static final int BUTTON_WIDTH = 300;
    private static final int BUTTON_HEIGHT = 90;
    private static final int BUTTON_SPACING = 150;
    private static final int BUTTON_ROUNDNESS = 10;
    
    public StartScreen(String titleText, int x, int y, int width, int height) {
        super(x, y, width, height);
        
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel(titleText);
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, FileSystem.getFile("TasteTheBacon.ttf")).deriveFont(70.0F);
        } catch (Exception e) {
            font = new Font("Sans-Serif", Font.PLAIN, 44);
        }
        title.setFont(font);
        int sw = title.getFontMetrics(font).stringWidth(titleText);
        title.setBounds(width / 2 - sw / 2, height / 2 - TITLE_HEIGHT / 2 - BUTTON_SPACING, sw, TITLE_HEIGHT);
        add(title);
        
        JButton play = new StartScreenButton(FileSystem.getImage("play_bacon.jpg"), BUTTON_ROUNDNESS, Color.BLUE);
        play.setBounds(width / 2 - BUTTON_WIDTH / 2, height / 2 - BUTTON_HEIGHT / 2, BUTTON_WIDTH, BUTTON_HEIGHT);
        play.addActionListener(new PlayAction());
        add(play);
    }
}
