package com.github.kaooot.nukkit.plugin.essentials.config;

import cn.nukkit.Player;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

import java.util.HashMap;
import java.util.Map;

public class PocketUserManager {

    private Map<String, PocketUserConfig> pocketUserConfigMap = new HashMap<>();
    private PocketEssentials plugin;

    public PocketUserManager( PocketEssentials plugin ) {
        this.plugin = plugin;
    }

    /**
     * Register a new configuration file
     * @param player who gets a new file
     */
    public void registerPlayer( Player player ) {
        this.pocketUserConfigMap.put( player.getUniqueId().toString(), new PocketUserConfig( player, this.plugin ) );
    }

    /**
     * Get the configuration class of the given file
     * @param uuid which is the name of the file
     * @return a fresh java class
     */
    public PocketUserConfig getPocketUserConfig( String uuid ) {
        return this.pocketUserConfigMap.get( uuid );
    }

    /**
     * Unregister an old configuration file
     * @param uuid which is the name of the file
     */
    public void unregisterPlayer( String uuid ) {
        this.pocketUserConfigMap.remove( uuid );
    }
}