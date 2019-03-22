package com.github.kaooot.nukkit.plugin.essentials.listener.player;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onPlayerQuit( PlayerQuitEvent event ) {
        event.setQuitMessage( "" );
    }
}