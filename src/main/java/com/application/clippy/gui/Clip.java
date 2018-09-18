/*
  Copyright (C) 2018 Enrico Bianchi (enrico.bianchi@gmail.com)
  Project       clippy
  Description   A simple clipboard manager
  License       GPL version 2 (see LICENSE for details)
 */
package com.application.clippy.gui;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Clip implements Runnable {

    private Clipboard clipboard;

    public Clip() {
        this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(10000);

                this.clipboard.setContents(new StringSelection(""), null);
            } catch (InterruptedException e) {
                System.exit(1);
            } catch (IllegalStateException e) {
            }
        }
    }
}
