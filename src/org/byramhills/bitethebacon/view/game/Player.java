package org.byramhills.bitethebacon.view.game;

import java.awt.Image;
import java.awt.image.BufferedImage;

import org.byramhills.bitethebacon.controller.FileSystem;

// represents a player. not responsible for rendering the player.
public class Player {
    private static final int SPEED = 1; // the amount of pixels moved by the player every move
    
    private int x;
    private int y;
    private final BufferedImage image;
    private final GameScreen parent;

    public Player(String img, int x, int y, GameScreen parent) {
        if(img == null || img.isEmpty() || parent == null) throw new IllegalArgumentException();
        
        this.image = FileSystem.getImage(img);
        if(this.image == null) throw new IllegalArgumentException();
        
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
    
    // moves the player vertically, up or down
    public void moveVert(boolean isUp) {
        int newY = y + (isUp ? -SPEED : SPEED);
        if(newY < 0 || newY > parent.getHeight() - getHeight()) return; // ensure the player will be moving on screen
        y = newY;
        parent.onPlayerMove(this); // must be called every time the player is moved in order to repaint the view
    }
    
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        
        if(obj instanceof Player) {
            Player other = (Player) obj;
            return other.x == x && other.y == y && other.getImage().equals(getImage());
        }
        return false;
    }
    
    @Override
    public String toString() {
        return String.format("Player[x=%d, y=%d]", x, y);
    }
}
