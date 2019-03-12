package com.github.kaooot.nukkit.plugin.essentials.config;

import cn.nukkit.Player;
import cn.nukkit.utils.Config;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

import java.io.File;

public class PocketUserConfig extends PocketConfig {

    private PocketEssentials plugin;

    /**
     * Creates / Saves the user config with the path plugins/PocketEssentials/userdata/uuid.yml in your Nukkit server and given defaults
     * @param plugin which is used to get the path of the Datafolder
     */
    public PocketUserConfig( Player player, PocketEssentials plugin ) {
        this.plugin = plugin;
        this.file = new File( this.plugin.getDataFolder().getPath() + "/userdata", player.getUniqueId().toString() + ".yml" );
        this.config = new Config( this.file );

        this.setDefaults();
    }

    @Override
    protected void setDefaults() {
        this.config.set( ".money", 0 );
        this.saveConfig();
    }

    @Override
    protected void saveConfig() {
        this.config.save( this.file );
    }

    /**
     * Get the money value from the user config
     * @return a fresh money value
     */
    public double getMoney() {
        return this.config.getDouble( ".money" );
    }

    /**
     * Change the money value from the user config
     * @param money which should be changed
     */
    public void setMoney( double money ) {
        this.config.set( ".money", money );
        this.saveConfig();
    }
}