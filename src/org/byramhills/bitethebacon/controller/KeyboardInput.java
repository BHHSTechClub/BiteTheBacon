package org.byramhills.bitethebacon.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import org.byramhills.bitethebacon.view.game.Player;

public class KeyboardInput {
    
    public static void initKeys(InputMap inputMap, ActionMap actionMap, Player player1, Player player2) {
        final String[] keys = {"W", "S", "UP", "DOWN"};
        final String[] ids = {"p1 up move", "p1 down move", "p2 up move", "p2 down move"};
        final MoveAction[] actions = {new MoveAction(player1, true), new MoveAction(player1, false), new MoveAction(player2, true), new MoveAction(player2, false)};
        
        assert keys.length == ids.length;
        assert ids.length == actions.length;
        for(int i=0; i<keys.length; i++) {
            KeyStroke stroke = KeyStroke.getKeyStroke("pressed " + keys[i]);
            inputMap.put(stroke, ids[i]);
            actionMap.put(ids[i], actions[i]);
            
            String rID = "released " + ids[i];
            KeyStroke release = KeyStroke.getKeyStroke("released " + keys[i]);
            inputMap.put(release, rID);
            final MoveAction temp = actions[i];
            actionMap.put(rID, new AbstractAction() {
                private static final long serialVersionUID = -8170481785364139357L;

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    temp.isDown = false;
                }});
        }
    }
    
    private static class MoveAction extends AbstractAction {
        private static final long serialVersionUID = -8199341783549910591L;
        private final Player subject;
        private final boolean isUp;
        volatile boolean isDown = false;
        
        public MoveAction(Player subject, boolean isUp) {
            this.subject = subject;
            this.isUp = isUp;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(isDown) return;
            isDown = true;
            
            new Thread() {
                @Override
                public void run() {
                    while(isDown) {
                        if(isUp) {
                            subject.moveUp();
                        } else {
                            subject.moveDown();
                        }
                        try {
                            Thread.sleep(2);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();
        }
    }
}
