package com.github.kaooot.nukkit.plugin.essentials.api.event;

import cn.nukkit.Player;

public class PlayerGodModeStatusChangeEvent extends PlayerStatusChangeEvent {

    public PlayerGodModeStatusChangeEvent( Player affected, boolean value ) {
        super( affected, value );
    }
}