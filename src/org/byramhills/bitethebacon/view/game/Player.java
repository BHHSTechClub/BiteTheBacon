package org.byramhills.bitethebacon.view.game;

import java.awt.Image;

import org.byramhills.bitethebacon.controller.FileSystem;

public class Player {
    private static final int SPEED = 1;
    
    private int x;
    private int y;
    private Image image;

    public Player(String img, int x, int y) {
        image = FileSystem.getImage(img);
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }
    
    public void moveUp() {
        y -= SPEED;
    }
    
    public void moveDown() {
        y += SPEED;
    }
}
