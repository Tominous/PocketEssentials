package com.github.kaooot.nukkit.plugin.essentials;

import cn.nukkit.Player;

public class Economy {

    private PocketEssentials plugin;

    public Economy( PocketEssentials plugin ) {
        this.plugin = plugin;
    }

    /**
     * Get the current money from a player who has already an own user data file
     * @param player who is the owner of the file
     * @return a fresh double value
     */
    public Double currentMoney( Player player ) {
        return this.plugin.getPocketUserManager().getPocketUserConfig( player.getUniqueId().toString() ).getMoney();
    }

    /**
     * Change the value of money from the given player
     * @param player who is needed to change the value
     * @param balance which should be changed
     */
    private void setMoney( Player player, double balance ) {
        this.plugin.getPocketUserManager().getPocketUserConfig( player.getUniqueId().toString() ).setMoney( balance );
    }

    public void giveMoney( Player player, double value ) {
        this.setMoney( player, this.currentMoney( player ) + value );
    }

    public void takeMoney( Player player, double value ) {
        this.setMoney( player, this.currentMoney( player ) - value );
    }

    public void resetBalance( Player player ) {
        this.setMoney( player, 0 );
    }
}