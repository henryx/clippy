/*
  Copyright (C) 2018 Enrico Bianchi (enrico.bianchi@gmail.com)
  Project       clippy
  Description   A simple clipboard manager
  License       GPL version 2 (see LICENSE for details)
 */
package com.application.clippy.gui.listeners;

import com.application.clippy.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AboutAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null,
                "Clippy version " + Main.VERSION,
                "Clippy",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
