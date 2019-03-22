package com.github.kaooot.nukkit.plugin.essentials;

import cn.nukkit.Player;

public class Economy implements com.github.kaooot.nukkit.plugin.essentials.api.Economy {

    private PocketEssentials plugin;

    Economy( PocketEssentials plugin ) {
        this.plugin = plugin;
    }

    @Override
    public Double currentMoney( Player player ) {
        return this.plugin.getPocketUserManager().getPocketUserConfig( player.getUniqueId().toString() ).getMoney();
    }

    @Override
    public void setMoney( Player player, double balance ) {
        this.plugin.getPocketUserManager().getPocketUserConfig( player.getUniqueId().toString() ).setMoney( balance );
    }

    @Override
    public void giveMoney( Player player, double value ) {
        this.setMoney( player, this.currentMoney( player ) + value );
    }

    @Override
    public void takeMoney( Player player, double value ) {
        this.setMoney( player, this.currentMoney( player ) - value );
    }

    @Override
    public void resetBalance( Player player ) {
        this.setMoney( player, 0 );
    }
}