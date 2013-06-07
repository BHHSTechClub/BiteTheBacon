package org.byramhills.bitethebacon.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class StartScreenButton extends JButton {
    private static final long serialVersionUID = -1095344357376019554L;
    private final String text;
    private final Color textColor;
    private final BufferedImage image;
    private final int roundness;
    private final Color color;
    
    public StartScreenButton(int roundness, Color color) {
        this((String) null, roundness, color);
    }
    
    public StartScreenButton(String text, int roundness, Color color) {
        this(text, Color.WHITE, roundness, color);
    }
    
    public StartScreenButton(String text, Color textColor, int roundness, Color color) {
        if((text != null && textColor == null) || roundness < 0 || color == null) throw new IllegalArgumentException();
        this.text = text;
        this.textColor = textColor;
        this.image = null;
        this.roundness = roundness;
        this.color = color;
    }
    
    public StartScreenButton(BufferedImage image, int roundness, Color color) {
        if(image == null || roundness < 0) throw new IllegalArgumentException();
        this.text = null;
        this.textColor = null;
        this.image = image;
        this.roundness = roundness;
        this.color = color;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        
        g.setColor(color);
        g.fillRoundRect(0, 0, width, height, roundness, roundness);
        if(image != null) {
            g.drawImage(image, width / 2 - image.getWidth() / 2, height / 2 - image.getHeight() / 2, color, null);
        } else if(text != null) {
            g.setColor(textColor);
            int sw = g.getFontMetrics().stringWidth(text);
            g.drawString(text, width / 2 - sw / 2, height / 2 + 5); // 5 is roughly the height of the string
        }
    }
}
