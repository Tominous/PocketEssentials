package com.github.kaooot.nukkit.plugin.essentials.listener.player;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class PlayerJoinListener implements Listener {

    private PocketEssentials plugin;

    public PlayerJoinListener( PocketEssentials plugin ) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin( PlayerJoinEvent event ) {
        Player player = event.getPlayer();

        event.setJoinMessage( "" );

        this.plugin.getPocketUserManager().registerPlayer( player );
    }
}