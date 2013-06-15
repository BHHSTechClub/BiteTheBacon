package org.byramhills.bitethebacon.view.options;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.byramhills.bitethebacon.model.Model;
import org.byramhills.bitethebacon.model.Options;
import org.byramhills.bitethebacon.view.MenuRenderingOptions;
import org.byramhills.bitethebacon.view.Screen;
import org.byramhills.bitethebacon.view.start.StartScreenButton;

public class OptionsScreen extends Screen {
    private static final long serialVersionUID = 6815340420264999985L;
    private final Options options = Model.getModel().getOptions();
    private final String[] buttonTexts = {"Keyboard Layout: " + options.getKeyboardLayout().toString(), "Back"};
    private final ActionListener[] actions = {new KeyboardLayoutAction(), new BackAction()};
    private final StartScreenButton[] buttons = new StartScreenButton[buttonTexts.length];

    public OptionsScreen(int x, int y, int width, int height, MenuRenderingOptions options) {
        super(x, y, width, height);
        setBackground(options.getBackgroundColor());
        
        assert buttonTexts.length == actions.length;
        for(int i=0; i<buttonTexts.length; i++) {
            StartScreenButton button = new StartScreenButton(buttonTexts[i], options.getButtonFont(), options.getButtonRoundness(), options.getButtonColor());
            int bWidth = options.getButtonWidth() + 300;
            int bHeight = options.getButtonHeight();
            button.setBounds(width / 2 - bWidth / 2, height / 2 - bHeight / 2 + (options.getButtonSpacing() * (i - buttonTexts.length / 2)), bWidth, bHeight);
            button.addActionListener(actions[i]);
            add(button);
            buttons[i] = button;
        }
    }
    
    private class KeyboardLayoutAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttons[0].setText("Keyboard Layout: " + options.nextKeyboardLayout().toString());
        }
    }
    
    private static class BackAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Model.getView().showTitle();
        }
    }
}
