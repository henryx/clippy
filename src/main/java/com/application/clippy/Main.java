/*
  Copyright (C) 2018 Enrico Bianchi (enrico.bianchi@gmail.com)
  Project       clippy
  Description   A simple clipboard manager
  License       GPL version 2 (see LICENSE for details)
 */

package com.application.clippy;

import com.application.clippy.gui.Tray;

public class Main {
    public static void main(String[] args) {
        Tray app;

        app = new Tray();
        app.show();
    }
}
