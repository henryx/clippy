/*
  Copyright (C) 2018 Enrico Bianchi (enrico.bianchi@gmail.com)
  Project       clippy
  Description   A simple clipboard manager
  License       GPL version 2 (see LICENSE for details)
 */
package com.application.clippy.gui;

import com.application.clippy.gui.listeners.AboutAction;
import com.application.clippy.gui.listeners.ExitAction;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tray {

    private TrayIcon trayIcon;
    private SystemTray tray;

    public Tray() {
        ClassLoader classloader;
        Image image;
        URL url;

        classloader = Thread.currentThread().getContextClassLoader();
        url = classloader.getResource("images/attach-2-16.png");
        image = Toolkit.getDefaultToolkit().getImage(url);

        this.trayIcon = new TrayIcon(image);
        this.tray = SystemTray.getSystemTray();

        this.createMenu();
    }

    private void createMenu() {
        MenuItem aboutItem, exitItem;
        PopupMenu popup;

        popup = new PopupMenu();

        aboutItem = new MenuItem("About");
        exitItem = new MenuItem("Exit");

        aboutItem.addActionListener(new AboutAction());
        exitItem.addActionListener(new ExitAction());

        popup.add(aboutItem);
        popup.addSeparator();
        popup.add(exitItem);

        this.trayIcon.setPopupMenu(popup);
    }

    public void show() {
        Thread t;

        try {

            t = new Thread(new Clip());
            t.setName("Clippy");
            t.start();

            this.tray.add(trayIcon);
        } catch (AWTException e) {
            JOptionPane.showMessageDialog(new JFrame(),
                    "Cannot open application: " + e.getMessage(),
                    "Clippy",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
