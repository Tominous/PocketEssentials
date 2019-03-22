package com.github.kaooot.nukkit.plugin.essentials.api.event;

import cn.nukkit.Player;
import cn.nukkit.event.player.PlayerEvent;

public class PlayerNicknameChangeEvent extends PlayerEvent {

    private String value;

    public PlayerNicknameChangeEvent( Player affected, String value ) {
        this.player = affected;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}