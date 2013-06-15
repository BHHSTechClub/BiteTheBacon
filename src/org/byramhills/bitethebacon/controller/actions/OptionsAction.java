package org.byramhills.bitethebacon.controller.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.byramhills.bitethebacon.model.Model;

public class OptionsAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Model.getView().showOptions();
    }
}
