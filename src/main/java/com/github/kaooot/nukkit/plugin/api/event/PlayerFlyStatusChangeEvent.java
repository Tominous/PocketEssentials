package com.github.kaooot.nukkit.plugin.api.event;

import cn.nukkit.Player;

public class PlayerFlyStatusChangeEvent extends PlayerStatusChangeEvent {

    public PlayerFlyStatusChangeEvent( Player affected, boolean value ) {
        super( affected, value );
    }
}