package org.byramhills.bitethebacon.view;

import javax.swing.JPanel;

public class Screen extends JPanel {
    private static final long serialVersionUID = -4903248431146475336L;
    
    public Screen(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        setLayout(null);
    }
}
