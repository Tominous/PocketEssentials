package com.github.kaooot.nukkit.plugin.essentials.listener.player;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerFoodLevelChangeEvent;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class PlayerFoodLevelChangeListener implements Listener {

    private PocketEssentials plugin;

    public PlayerFoodLevelChangeListener( PocketEssentials plugin ) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerFoodLevelChange( PlayerFoodLevelChangeEvent event ) {
        if ( this.plugin.getPocketUserManager().getPocketUserConfig( event.getPlayer().getUniqueId().toString() ).isGodMode() )
            event.setCancelled( true );
    }
}