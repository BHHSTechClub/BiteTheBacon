package org.byramhills.bitethebacon.model;

public class Options {
    public enum KeyboardLayout {
        QWERTY("W", "S", "UP", "DOWN"),
        DVORAK("O", "Q", "UP", "DOWN");
        
        private final String p1up;
        private final String p1down;
        private final String p2up;
        private final String p2down;
        
        private KeyboardLayout(String p1up, String p1down, String p2up, String p2down) {
            this.p1up = p1up;
            this.p1down = p1down;
            this.p2up = p2up;
            this.p2down = p2down;
        }
        
        public String[] getPlayerControls() {
            return new String[] {p1up, p1down, p2up, p2down};
        }
    }
    
    private KeyboardLayout keyboard = KeyboardLayout.QWERTY; // QWERTY is default
    
    public KeyboardLayout getKeyboardLayout() {
        return keyboard;
    }
    
    public void setKeyboardLayout(KeyboardLayout layout) {
        this.keyboard = layout;
    }
    
    // toggles to and returns the next layout
    public KeyboardLayout nextKeyboardLayout() {
        int index = keyboard.ordinal() + 1;
        KeyboardLayout[] vals = KeyboardLayout.values();
        if(index >= vals.length) index = 0;
        keyboard = vals[index];
        return keyboard;
    }
}
