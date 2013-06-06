package org.byramhills.bitethebacon.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

public class StartScreenButton extends JButton {
    private static final long serialVersionUID = -1095344357376019554L;
    private final String text;
    private final Color textColor;
    private final int roundness;
    private final Color color;
    
    public StartScreenButton(int roundness, Color color) {
        this("", roundness, color);
    }
    
    public StartScreenButton(String text, int roundness, Color color) {
        this(text, Color.WHITE, roundness, color);
    }
    
    public StartScreenButton(String text, Color textColor, int roundness, Color color) {
        this.text = text;
        this.textColor = textColor;
        this.roundness = roundness;
        this.color = color;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRoundRect(0, 0, getWidth(), getHeight(), roundness, roundness);
        g.setColor(textColor);
        int sw = g.getFontMetrics().stringWidth(text);
        g.drawString(text, getWidth() / 2 - sw / 2, getHeight() / 2 + 5); // 5 is roughly the height of the string
    }
}
