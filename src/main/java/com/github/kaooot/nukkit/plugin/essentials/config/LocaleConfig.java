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
        this.config.set( "Translations.defaultLocale", "en" );
        this.config.set( "Translations.messages.message-onEnable-en", TextFormat.GREEN + "ENABLED" );
        this.config.set( "Translations.messages.message-onDisable-en", TextFormat.RED + "DISABLED" );
        this.config.set( "Translations.messages.message-command-noPerm-en", TextFormat.DARK_RED + "You are not allowed to use this command." );
        this.config.set( "Translations.messages.message-command-noPerm-console-en", TextFormat.RED + "%s" + TextFormat.DARK_RED + " does not have an access to this command." );
        this.config.set( "Translations.messages.message-command-playerNotFound-en", TextFormat.RED + "Error: " + TextFormat.DARK_RED + "Player not found." );
        this.config.set( "Translations.messages.message-command-fly-success-en", TextFormat.GOLD + "You have " + TextFormat.WHITE + "activated " + TextFormat.GOLD + "the flight mode at " + TextFormat.RESET + "%s" );
        this.config.set( "Translations.messages.message-command-fly-fail-en", TextFormat.GOLD + "You have " + TextFormat.WHITE + "deactivated " + TextFormat.GOLD + "the flight mode at " + TextFormat.RESET + "%s" );
        this.config.set( "Translations.messages.message-command-godMode-success-en", TextFormat.GOLD + "Godmode " + TextFormat.RED + "enabled" );
        this.config.set( "Translations.messages.message-command-godMode-fail-en", TextFormat.GOLD + "Godmode " + TextFormat.RED + "disabled" );
        this.config.set( "Translations.messages.message-command-feed-success-en", TextFormat.GOLD + "Your hunger was stilled." );
        this.config.set( "Translations.messages.message-command-feed-success-other-en", TextFormat.GOLD + "You have stilled the hunger from " + TextFormat.RESET + "%s" );
        this.config.set( "Translations.messages.message-command-heal-success-en", TextFormat.GOLD + "You were healed." );
        this.config.set( "Translations.messages.message-command-heal-success-other-en", TextFormat.RESET + "%s" + TextFormat.GOLD + " was healed." );
        this.saveConfig();
    }

    @Override
    protected void saveConfig() {
        this.config.save( this.file );
    }

    /**
     * Get a message with the given key from the locale config
     * @param key which is the path of the value in the configuration data
     * @return a fresh message from the config
     */
    public String getMessageFromConfiguration( String key ) {
        return this.config.getString( key );
    }

    /**
     * Get the standard language (shorthand symbol)
     * @return the default locale of PocketEssentials, which is set to English by default
     */
    public String getDefaultLocale() {
        return this.config.getString( "Translations.defaultLocale" );
    }
}