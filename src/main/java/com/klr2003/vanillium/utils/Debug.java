package com.klr2003.vanillium.utils;

public class Debug {
    public Debug() {
        MessageHandler.infoMessage("Starting in Debug Mode...");
        MessageHandler.infoMessage("Config Values: " + ConfigHandler.config);
    }
}
