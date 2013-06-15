package org.byramhills.bitethebacon.model;

import org.byramhills.bitethebacon.view.View;

public class Model {
    private static Model model;
    private final View view;
    private final Options options;
    
    public Model() {
        model = this;
        
        options = new Options();
        view = new View();
    }
    
    public Options getOptions() {
        return options;
    }
    
    public static Model getModel() {
        return model;
    }
    
    public static View getView() {
        return getModel().view;
    }
}
