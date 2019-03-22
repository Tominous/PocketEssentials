package com.github.kaooot.nukkit.plugin.essentials.api.event;

import cn.nukkit.Player;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.player.PlayerEvent;

public class PlayerStatusChangeEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private boolean value;

    public static HandlerList getHandlers() {
        return handlers;
    }

    public PlayerStatusChangeEvent( Player affected, boolean value ) {
        this.player = affected;
        this.value = value;
    }

    public boolean getValue() {
        return this.value;
    }
}