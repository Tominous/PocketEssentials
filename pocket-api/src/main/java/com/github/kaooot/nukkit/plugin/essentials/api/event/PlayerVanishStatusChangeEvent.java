package com.github.kaooot.nukkit.plugin.essentials.api.event;

import cn.nukkit.Player;

public class PlayerVanishStatusChangeEvent extends PlayerStatusChangeEvent {

    public PlayerVanishStatusChangeEvent( Player affected, boolean value ) {
        super( affected, value );
    }
}