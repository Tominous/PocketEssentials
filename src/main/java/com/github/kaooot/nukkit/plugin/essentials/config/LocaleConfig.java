package com.github.kaooot.nukkit.plugin.essentials.config;

import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

import java.io.File;

public class LocaleConfig extends PocketConfig {

    private PocketEssentials plugin;

    public LocaleConfig( PocketEssentials plugin ) {
        this.plugin = plugin;
        this.file = new File( this.plugin.getDataFolder().getPath(), "locale.yml" );
        this.config = new Config( this.file );

        this.setDefaults();
    }

    @Override
    protected void setDefaults() {
        this.config.set( "Translations.defaultLocale", "en" );
        this.config.set( "Translations.messages.message-onEnable-en", TextFormat.GREEN + "ENABLED" );
        this.config.set( "Translations.messages.message-onDisable-en", TextFormat.RED + "DISABLED" );
        this.saveConfig();
    }

    @Override
    protected void saveConfig() {
        this.config.save( this.file );
    }

    public String getMessageFromConfiguration( String key ) {
        return this.config.getString( key );
    }

    public String getDefaultLocale() {
        return this.config.getString( "Translations.defaultLocale" );
    }
}