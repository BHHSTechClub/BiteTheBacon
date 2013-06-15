package org.byramhills.bitethebacon.view.game;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.byramhills.bitethebacon.controller.FileSystem;

public class Player {
    private static final int SPEED = 1;
    
    private int x;
    private int y;
    private final BufferedImage image;
    private final GameScreen parent;

    public Player(String img, int x, int y, GameScreen parent) {
        this.image = FileSystem.getImage(img);
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getWidth() {
        return image.getWidth();
    }
    
    public int getHeight() {
        return image.getHeight();
    }

    public Image getImage() {
        return image;
    }
    
    public void moveVert(boolean isUp) {
        int newY = y + (isUp ? -SPEED : SPEED);
        if(newY < 0 || newY > parent.getHeight() - getHeight()) return;
        y = newY;
        parent.onPlayerMove(this);
    }
}
