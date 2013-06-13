package org.byramhills.bitethebacon.view.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;


import javax.swing.JLabel;
import org.byramhills.bitethebacon.view.Screen;


public class GameScreen extends Screen {
    private static final long serialVersionUID = 7461228168599865247L;
    public JLabel score;
    public int scorei;
    Player player1;
    Player player2;
    
    public GameScreen(int x, int y, int width, int height) {
    	super(x, y, width, height);
        setBackground(Color.white);
    }
    
    public void paint(Graphics g)
    {
      super.paint(g);
      
      Graphics2D g2 = (Graphics2D) g;
      
      //set rendering options 
      RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
      
      g2.setRenderingHints(rh);
      
      scorei = 0;
      score = new JLabel("Score: " + scorei);
      score.setSize(getPreferredSize());
      score.setBounds(10, -15, 300, 100);   
      score.setFont(new Font("Sans-Serif", Font.PLAIN, 32));
      add(score);
      
      player1 = new Player("player1.jpeg", 600, 500);
      player2 = new Player("player2.jpeg", 300, 500);
      g2.drawImage(player1.getImage(), player1.getX(), player1.getY(), this);
      g2.drawImage(player2.getImage(), player2.getX(), player2.getY(), this);
      //TODO: paint the environment, make a bacon class for the bacon slide, add movements to blobs
      repaint();
    }
}
