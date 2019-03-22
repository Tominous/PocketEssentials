package com.github.kaooot.nukkit.plugin.essentials.api;

public interface APIManager {

    /**
     * Call our Economy interface
     * @param economyClass The class which is needed to use it in other plugins
     * @return an fresh economy class
     */
    Economy callEconomy( Class<Economy> economyClass );
}