package com.github.kaooot.nukkit.plugin.essentials.testplugin.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import com.github.kaooot.nukkit.plugin.essentials.testplugin.TestPlugin;
import com.github.kaooot.nukkit.plugin.essentials.api.Economy;

public class PlayerJoinListener implements Listener {

    private TestPlugin plugin;

    public PlayerJoinListener( TestPlugin plugin ) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin( PlayerJoinEvent event ) {
        Economy economy = this.plugin.getPocketEssentialsAPI().getApiManager().callEconomy( Economy.class );
        event.getPlayer().sendMessage( "Your money : " + economy.currentMoney( event.getPlayer() ) );
    }
}