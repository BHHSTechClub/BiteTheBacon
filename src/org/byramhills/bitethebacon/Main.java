package org.byramhills.bitethebacon;

import org.byramhills.bitethebacon.model.Model;

public class Main {
    
    public static void main(String[] args) {
        new Model();
        //flow:
        //model -> view -> new screen/startscreen -> startscreenbutton
        //mouselistner for getting clicks -> play pressed -> new gamescreen
        //events now pass to gamescreen
    }
}
