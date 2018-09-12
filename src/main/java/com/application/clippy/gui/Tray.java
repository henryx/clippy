/*
  Copyright (C) 2018 Enrico Bianchi (enrico.bianchi@gmail.com)
  Project       clippy
  Description   A simple clipboard manager
  License       GPL version 2 (see LICENSE for details)
 */

package com.application.clippy.gui;


import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Tray {
    private TrayIcon trayIcon;
    private SystemTray tray;

    public Tray() {
        Image image;
        URL url;

        url = System.class.getResource("/images/new.png");
        image = Toolkit.getDefaultToolkit().getImage(url);

        this.trayIcon = new TrayIcon(image);
        this.tray = SystemTray.getSystemTray();

        this.createMenu();
    }

    private void createMenu() {

        MenuItem aboutItem;
        MenuItem exitItem;
        PopupMenu popup;

        popup = new PopupMenu();

        aboutItem = new MenuItem("About");
        exitItem = new MenuItem("Exit");

        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);

        this.trayIcon.setPopupMenu(popup);
    }

    public void show() {
        try {
            this.tray.add(trayIcon);
        } catch (AWTException e) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Cannot open application: " + e.getMessage(),
                    "Clippy",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}