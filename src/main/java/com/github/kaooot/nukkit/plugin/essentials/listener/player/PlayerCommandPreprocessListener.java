package com.github.kaooot.nukkit.plugin.essentials.listener.player;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class PlayerCommandPreprocessListener implements Listener {

    private PocketEssentials plugin;

    public PlayerCommandPreprocessListener( PocketEssentials plugin ) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerCommandPreprocess( PlayerCommandPreprocessEvent event ) {
        // print a warn message in the console when a player is executing a command
        this.plugin.getLogger().warning( event.getPlayer().getName() + " issued the following command: " + event.getMessage() );
    }
}