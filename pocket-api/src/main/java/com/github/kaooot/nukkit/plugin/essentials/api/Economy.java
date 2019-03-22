package com.github.kaooot.nukkit.plugin.essentials.api;

import cn.nukkit.Player;

public interface Economy extends APIElement {

    /**
     * Get the current money from a player who has already an own user data file
     * @param player who is the owner of the file
     * @return a fresh double value
     */
    Double currentMoney( Player player );

    /**
     * Change the value of money from the given player
     * @param player who is needed to change the value
     * @param balance which should be changed
     */
    void setMoney( Player player, double balance );

    /**
     * Adds the value of money to the given player
     * @param player who is needed to change the value
     * @param value which should be added
     */
    void giveMoney( Player player, double value );

    /**
     * Takes the value of money from the given player
     * @param player who is needed to change the value
     * @param value which should be taken
     */
    void takeMoney( Player player, double value );

    /**
     * Resets the money of the given player
     * @param player who is needed to reset the money
     */
    void resetBalance( Player player );
}