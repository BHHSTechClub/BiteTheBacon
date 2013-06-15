package org.byramhills.bitethebacon.view.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import org.byramhills.bitethebacon.controller.KeyboardInput;
import org.byramhills.bitethebacon.view.Screen;
import org.byramhills.bitethebacon.view.View;


public class GameScreen extends Screen {
    private static final long serialVersionUID = 7461228168599865247L;
    private final Player player1;
    private final Player player2;
    
    public GameScreen(View parent, int x, int y, int width, int height) {
    	super(x, y, width, height);
        setBackground(Color.WHITE);
        
        player1 = new Player("player1.jpeg", 600, 500, this);
        player2 = new Player("player2.jpeg", 300, 500, this);
        
        KeyboardInput.initKeys(getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW), getActionMap(), player1, player2);
    }
    
    @Override
    public void paint(Graphics g)
    {
      super.paint(g);
      
      Graphics2D g2 = (Graphics2D) g;
      
      //set rendering options 
      RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      
      g2.setRenderingHints(rh);
      
      g2.drawImage(player1.getImage(), player1.getX(), player1.getY(), this);
      g2.drawImage(player2.getImage(), player2.getX(), player2.getY(), this);
      //TODO: paint the environment, make a bacon class for the bacon slide
    }
    
    public void onPlayerMove(Player player) {
        repaint();
    }
}
