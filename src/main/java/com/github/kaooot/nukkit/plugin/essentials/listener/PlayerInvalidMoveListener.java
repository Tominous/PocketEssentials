package com.github.kaooot.nukkit.plugin.essentials.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInvalidMoveEvent;

public class PlayerInvalidMoveListener implements Listener {

    // disable the Nukkit anticheat to reduce plugin-side bugs
    @EventHandler( priority = EventPriority.LOW )
    public void onPlayerInvalidMove( PlayerInvalidMoveEvent event ) {
        event.setCancelled( true );
    }
}