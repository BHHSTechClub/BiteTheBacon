package org.byramhills.bitethebacon.view;

import java.awt.Color;
import java.awt.Font;

public class MenuRenderingOptions {
    private final int buttonWidth;
    private final int buttonHeight;
    private final int buttonSpacing;
    private final int buttonRoundness;
    private final Color buttonColor;
    private final Color backgroundColor;
    private final Font buttonFont;
    
    public MenuRenderingOptions(int buttonWidth, int buttonHeight, int buttonSpacing, int buttonRoundness, Color buttonColor, Color backgroundColor, Font buttonFont) {
        this.buttonWidth = buttonWidth;
        this.buttonHeight = buttonHeight;
        this.buttonSpacing = buttonSpacing;
        this.buttonRoundness = buttonRoundness;
        this.buttonColor = buttonColor;
        this.backgroundColor = backgroundColor;
        this.buttonFont = buttonFont;
    }
    
    public int getButtonWidth() {
        return buttonWidth;
    }
    
    public int getButtonHeight() {
        return buttonHeight;
    }
    
    public int getButtonSpacing() {
        return buttonSpacing;
    }
    
    public int getButtonRoundness() {
        return buttonRoundness;
    }
    
    public Color getButtonColor() {
        return buttonColor;
    }
    
    public Color getBackgroundColor() {
        return backgroundColor;
    }
    
    public Font getButtonFont() {
        return buttonFont;
    }
}
