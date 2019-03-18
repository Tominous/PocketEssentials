package com.github.kaooot.nukkit.plugin.essentials.config;

import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

import java.io.File;

public class LocaleConfig extends PocketConfig {

    private PocketEssentials plugin;

    /**
     * Creates / Saves the locale config with the path plugins/PocketEssentials/locale.yml in your Nukkit server and given defaults
     * @param plugin which is used to get the path of the Datafolder
     */
    public LocaleConfig( PocketEssentials plugin ) {
        this.plugin = plugin;
        this.file = new File( this.plugin.getDataFolder().getPath(), "locale.yml" );
        this.config = new Config( this.file );

        this.setDefaults();
    }

    @Override
    protected void setDefaults() {
        this.config.set( ".defaultLocale", "en_US" );
        this.saveConfig();
    }

    @Override
    protected void saveConfig() {
        this.config.save( this.file );
    }

    /**
     * Get the standard language (shorthand symbol)
     * @return the default locale of PocketEssentials, which is set to English by default
     */
    public String getDefaultLocale() {
        return this.config.getString( ".defaultLocale" );
    }
}