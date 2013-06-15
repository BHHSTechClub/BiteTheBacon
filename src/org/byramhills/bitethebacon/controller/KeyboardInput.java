package org.byramhills.bitethebacon.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

import org.byramhills.bitethebacon.view.game.Player;

public class KeyboardInput {
    // initializes the keyboard-based input controls for the game
    public static void initKeys(InputMap inputMap, ActionMap actionMap, Player player1, Player player2) {
        final String[] keys = {"W", "S", "UP", "DOWN"}; // string representations of the keys
        final Player[] players = {player1, player1, player2, player2}; // the players affected by each key
        final boolean[] upDown = {true, false, true, false}; // the response (up or down) to each key
        
        // just want to double-check our work
        assert keys.length == players.length;
        assert players.length == upDown.length;
        
        for(int i=0; i<keys.length; i++) {
            String id = (players[i].equals(player1) ? "p1" : "p2") + " " + (upDown[i] ? "up" : "down") + " move"; // generate a unique id for this control
            final MoveAction action = new MoveAction(players[i], upDown[i]); // generate an action for the key
            
            // action for pressing the key
            KeyStroke stroke = KeyStroke.getKeyStroke("pressed " + keys[i]);
            inputMap.put(stroke, id);
            actionMap.put(id, action);
            
            // action for releasing the key
            String rID = "released " + id; // new id for key release
            KeyStroke release = KeyStroke.getKeyStroke("released " + keys[i]);
            inputMap.put(release, rID);
            actionMap.put(rID, new AbstractAction() {
                private static final long serialVersionUID = -8170481785364139357L;

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    action.isDown = false;
                }});
        }
    }
    
    private static class MoveAction extends AbstractAction {
        private static final long serialVersionUID = -8199341783549910591L;
        private final Player subject;
        private final boolean isUp;
        volatile boolean isDown = false; // volatile ensures thread safety
        
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
                        subject.moveVert(isUp);
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
