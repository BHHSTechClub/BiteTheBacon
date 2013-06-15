package org.byramhills.bitethebacon.view.start;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

public class StartScreenButton extends JButton {
    private static final long serialVersionUID = -1095344357376019554L;
    private String text; // text to display on the button
    private final Color textColor; // color of the text to display
    private final Font textFont; // size of text to display
    private final BufferedImage image; // image to display
    private final BufferedImage pressedImage; // slightly darker than regular image
    private final int roundness; // roundness of the button's edge
    private final Color color; // background color of the button
    private boolean pressed = false; // whether or not the button is pressed
    
    public StartScreenButton(int roundness, Color color) {
        this((String) null, roundness, color);
    }
    
    public StartScreenButton(String text, int roundness, Color color) {
        this(text, Color.WHITE, roundness, color);
    }
    
    public StartScreenButton(String text, Font textFont, int roundness, Color color) {
        this(text, Color.WHITE, textFont, roundness, color);
    }
    
    public StartScreenButton(String text, Color textColor, int roundness, Color color) {
        this(text, textColor, null, roundness, color);
    }
    
    public StartScreenButton(String text, Color textColor, Font textFont, int roundness, Color color) {
        this(text, textColor, textFont, null, roundness, color);
    }
    
    public StartScreenButton(BufferedImage image, int roundness, Color color) {
        this(null, null, null, image, roundness, color);
    }
    
    private StartScreenButton(String text, Color textColor, Font textFont, BufferedImage image, int roundness, Color color) {
        if((text != null && textColor == null) || !(text == null ^ image == null) || roundness < 0 || (image == null && color == null)) throw new IllegalArgumentException();
        
        this.text = text;
        this.textColor = textColor;
        this.textFont = textFont;
        this.image = image;
        this.roundness = roundness;
        this.color = color;
        
        if(image == null) {
            pressedImage = null;
        } else {
            int w = image.getWidth();
            int h = image.getHeight();
            pressedImage = new BufferedImage(w, h, image.getType());
            for(int i=0; i<w; i++) {
                for(int j=0; j<h; j++) {
                    pressedImage.setRGB(i, j, new Color(image.getRGB(i, j)).darker().getRGB());
                }
            }
        }
        
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent arg0) {}

            @Override
            public void mouseEntered(MouseEvent arg0) {}

            @Override
            public void mouseExited(MouseEvent arg0) {}

            @Override
            public void mousePressed(MouseEvent arg0) {
                pressed = true;
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                pressed = false;
            }});
    }
    
    @Override
    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        
        g.setColor(pressed ? color.darker() : color); // darker when pressed
        g.fillRoundRect(0, 0, width, height, roundness, roundness);
        if(image != null) {
            g.drawImage(pressed ? pressedImage : image, width / 2 - image.getWidth() / 2, height / 2 - image.getHeight() / 2, color, null); // again, darker when pressed
        } else if(text != null) {
            g.setColor(textColor);
            if(textFont != null) g.setFont(textFont);
            FontMetrics fm = g.getFontMetrics();
            int sw = fm.stringWidth(text);
            g.drawString(text, width / 2 - sw / 2, height / 2 + fm.getHeight() / 4);
        }
    }
    
    @Override
    public void setText(String text) {
        this.text = text;
    }
    
    @Override
    public String getText() {
        return text;
    }
}
