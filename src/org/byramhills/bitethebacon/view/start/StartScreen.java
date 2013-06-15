package org.byramhills.bitethebacon.view.start;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.byramhills.bitethebacon.controller.FileSystem;
import org.byramhills.bitethebacon.controller.actions.OptionsAction;
import org.byramhills.bitethebacon.controller.actions.PlayAction;
import org.byramhills.bitethebacon.view.MenuRenderingOptions;
import org.byramhills.bitethebacon.view.Screen;

public class StartScreen extends Screen {
    private static final long serialVersionUID = 1314346261904481787L;
    
    private static final int TITLE_HEIGHT = 95;
    
    public StartScreen(String titleText, int x, int y, int width, int height, MenuRenderingOptions options) {
        super(x, y, width, height);
        
        setBackground(options.getBackgroundColor());
        
        JLabel title = new JLabel(titleText);
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, FileSystem.getFile("TasteTheBacon.ttf")).deriveFont(70.0F);
        } catch (Exception e) {
            font = options.getButtonFont();
            font = font.deriveFont((float) font.getSize() + 10);
        }
        title.setFont(font);
        int sw = title.getFontMetrics(font).stringWidth(titleText);
        title.setBounds(width / 2 - sw / 2, height / 2 - TITLE_HEIGHT / 2 - options.getButtonSpacing(), sw, TITLE_HEIGHT);
        add(title);
        
        JButton play = new StartScreenButton(FileSystem.getImage("play_bacon.jpg"), options.getButtonRoundness(), options.getButtonColor());
        play.setBounds(width / 2 - options.getButtonWidth() / 2, height / 2 - options.getButtonHeight() / 2, options.getButtonWidth(), options.getButtonHeight());
        play.addActionListener(new PlayAction());
        add(play);
        
        JButton optionsButton = new StartScreenButton("Options", options.getButtonFont(), options.getButtonRoundness(), options.getButtonColor());
        optionsButton.setBounds(width / 2 - options.getButtonWidth() / 2, height / 2 - options.getButtonHeight() / 2 + options.getButtonSpacing(), options.getButtonWidth(), options.getButtonHeight());
        optionsButton.addActionListener(new OptionsAction());
        add(optionsButton);
    }
}
