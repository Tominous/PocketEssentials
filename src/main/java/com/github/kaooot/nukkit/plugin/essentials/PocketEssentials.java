package com.github.kaooot.nukkit.plugin.essentials;

import cn.nukkit.plugin.PluginBase;
import com.github.kaooot.nukkit.plugin.essentials.command.FeedCommand;
import com.github.kaooot.nukkit.plugin.essentials.command.FlyCommand;
import com.github.kaooot.nukkit.plugin.essentials.command.GodModeCommand;
import com.github.kaooot.nukkit.plugin.essentials.command.HealCommand;
import com.github.kaooot.nukkit.plugin.essentials.config.LocaleConfig;
import com.github.kaooot.nukkit.plugin.essentials.config.PocketUserManager;
import com.github.kaooot.nukkit.plugin.essentials.listener.entity.EntityDamageListener;
import com.github.kaooot.nukkit.plugin.essentials.listener.player.*;
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
    @Getter
    private LocaleManager localeManager;

    /**
     * This method will be executed when the plugin is running / the server starts
     */
    @Override
    public void onEnable() {
        this.localeConfig = new LocaleConfig( this );
        this.localeManager = new LocaleManager();
        this.pocketUserManager = new PocketUserManager( this );

        this.registerListeners();
        this.registerCommands();

        this.getLogger().info( this.localeManager.translate( this.localeConfig.getDefaultLocale(), "message-onEnable" ) );
    }

    /**
     * This method will be executed when the server shuts down
     */
    @Override
    public void onDisable() {
        this.getLogger().info( this.localeManager.translate( this.localeConfig.getDefaultLocale(), "message-onDisable" ) );
    }

    // We use this private method to register Listener classes
    private void registerListeners() {
        this.getServer().getPluginManager().registerEvents( new PlayerInvalidMoveListener(), this );
        this.getServer().getPluginManager().registerEvents( new PlayerCommandPreprocessListener( this ), this );
        this.getServer().getPluginManager().registerEvents( new PlayerJoinListener( this ), this );
        this.getServer().getPluginManager().registerEvents( new PlayerQuitListener(), this );
        this.getServer().getPluginManager().registerEvents( new PlayerFoodLevelChangeListener( this ), this );
        this.getServer().getPluginManager().registerEvents( new EntityDamageListener( this ), this );
    }

    // We use this private method to register Command classes
    private void registerCommands() {
        this.getServer().getCommandMap().register( "fly", new FlyCommand( this, "fly", "Take off, and soar!" ) );
        this.getServer().getCommandMap().register( "god", new GodModeCommand( this, "god", "Enables your godly powers." ) );
        this.getServer().getCommandMap().register( "feed", new FeedCommand( this, "feed", "Satisfy the hunger." ) );
        this.getServer().getCommandMap().register( "heal", new HealCommand( this, "heal", "Heals you or the given player." ) );
    }
}