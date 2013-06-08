package org.byramhills.bitethebacon.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.byramhills.bitethebacon.view.game.GameScreen;
import org.byramhills.bitethebacon.view.start.StartScreen;

public class View extends JFrame {
    private static final long serialVersionUID = -265435613379508221L;
    private static final String TITLE = "Bite the Bacon";
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
    private final JPanel startScreen;
    
    public View() {
        super(TITLE);
        
        setBounds(getCentered(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        startScreen = new StartScreen(TITLE, 0, 0, WIDTH, HEIGHT);
        add(startScreen);
        
        setVisible(true);
    }
    
    public void startGame() {
        remove(startScreen);
        add(new GameScreen(0, 0, WIDTH, HEIGHT));
        repaint();
    }
    
    private static Rectangle getCentered(int width, int height) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        return new Rectangle(d.width / 2 - width / 2, d.height / 2 - height / 2, width, height);
    }
}
