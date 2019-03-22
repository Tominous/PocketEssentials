package com.github.kaooot.nukkit.plugin.essentials.listener.entity;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class EntityDamageListener implements Listener {

    private PocketEssentials plugin;

    public EntityDamageListener( PocketEssentials plugin ) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamageByEntity( EntityDamageByEntityEvent event ) {
        if ( this.plugin.getPocketUserManager().getPocketUserConfig( ((Player) event.getEntity()).getUniqueId().toString() ).isGodMode() )
            event.setCancelled( true );
    }

    @EventHandler
    public void onEntityDamage( EntityDamageEvent event ) {
        if ( this.plugin.getPocketUserManager().getPocketUserConfig( ((Player)event.getEntity()).getUniqueId().toString() ).isGodMode() )
            event.setCancelled( true );
    }
}