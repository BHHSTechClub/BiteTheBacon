package org.byramhills.bitethebacon.view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.JFrame;

import org.byramhills.bitethebacon.view.game.GameScreen;
import org.byramhills.bitethebacon.view.options.OptionsScreen;
import org.byramhills.bitethebacon.view.start.StartScreen;

public class View extends JFrame {
    private static final long serialVersionUID = -265435613379508221L;
    private static final String TITLE = "Bite the Bacon";
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 700;
    private Screen currentScreen;
    
    public View() {
        super(TITLE);
        
        setBounds(getCentered(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        
        currentScreen = new StartScreen(TITLE, 0, 0, WIDTH, HEIGHT);
        add(currentScreen);
        
        setVisible(true);
    }
    
    public void startGame() {
        replaceScreen(new GameScreen(this, 0, 0, WIDTH, HEIGHT)); //adds JPanel game
    }
    
    public void showOptions() {
        replaceScreen(new OptionsScreen(0, 0, WIDTH, HEIGHT));
    }
    
    private void replaceScreen(Screen next) {
        remove(currentScreen);
        currentScreen = next;
        add(next);
        repaint();
    }
    
    private static Rectangle getCentered(int width, int height) {
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        return new Rectangle(d.width / 2 - width / 2, d.height / 2 - height / 2, width, height);
    }
}
