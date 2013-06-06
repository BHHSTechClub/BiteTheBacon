package org.byramhills.bitethebacon.model;

import org.byramhills.bitethebacon.view.View;

public class Model {
    private static Model model;
    private final View view;
    
    public Model() {
        model = this;
        
        view = new View();
    }
    
    public static Model getModel() {
        return model;
    }
    
    public static View getView() {
        return getModel().view;
    }
}
