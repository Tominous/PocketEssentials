package com.github.kaooot.nukkit.plugin.essentials;

import cn.nukkit.plugin.PluginBase;
import com.github.kaooot.nukkit.plugin.essentials.command.FlyCommand;
import com.github.kaooot.nukkit.plugin.essentials.config.LocaleConfig;
import com.github.kaooot.nukkit.plugin.essentials.config.PocketUserManager;
import com.github.kaooot.nukkit.plugin.essentials.listener.PlayerCommandPreprocessListener;
import com.github.kaooot.nukkit.plugin.essentials.listener.PlayerInvalidMoveListener;
import com.github.kaooot.nukkit.plugin.essentials.listener.PlayerJoinListener;
import com.github.kaooot.nukkit.plugin.essentials.listener.PlayerQuitListener;
import lombok.Getter;

/*
 * Copyright (c) 2019, PocketEssentials and Kaooot
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */
public class PocketEssentials extends PluginBase {

    @Getter
    private LocaleConfig localeConfig;
    @Getter
    private PocketUserManager pocketUserManager;

    /**
     * This method will be executed when the plugin is running / the server starts
     */
    @Override
    public void onEnable() {
        this.localeConfig = new LocaleConfig( this );
        this.pocketUserManager = new PocketUserManager( this );

        this.registerListeners();
        this.registerCommands();

        this.getLogger().info( this.localeConfig.getMessageFromConfiguration( "Translations.messages.message-onEnable-" + this.localeConfig.getDefaultLocale() ) );
    }

    /**
     * This method will be executed when the server shuts down
     */
    @Override
    public void onDisable() {
        this.getLogger().info( this.localeConfig.getMessageFromConfiguration( "Translations.messages.message-onDisable-" + this.localeConfig.getDefaultLocale() ) );
    }

    // We use this private method to register Listener classes
    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents( new PlayerInvalidMoveListener(), this );
        this.getServer().getPluginManager().registerEvents( new PlayerCommandPreprocessListener( this ), this );
        this.getServer().getPluginManager().registerEvents( new PlayerJoinListener( this ), this );
        this.getServer().getPluginManager().registerEvents( new PlayerQuitListener(), this );
    }

    // We use this private method to register Command classes
    private void registerCommands() {
        this.getServer().getCommandMap().register( "fly", new FlyCommand( this, "fly" ) );
    }
}