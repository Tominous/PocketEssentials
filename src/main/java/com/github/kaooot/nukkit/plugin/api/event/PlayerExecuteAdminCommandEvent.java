package com.github.kaooot.nukkit.plugin.api.event;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.event.player.PlayerEvent;

public class PlayerExecuteAdminCommandEvent extends PlayerEvent {

    private Command command;
    private String neededPermission;
    private String executeFailMessage;

    public PlayerExecuteAdminCommandEvent( Player commandExecutor, Command command, String neededPermission, String executeFailMessage ) {
        this.player = commandExecutor;
        this.command = command;
        this.neededPermission = neededPermission;
        this.executeFailMessage = executeFailMessage;
    }

    public Command getCommand() {
        return this.command;
    }

    public String getNeededPermission() {
        return this.neededPermission;
    }

    public String getExecuteFailMessage() {
        return this.executeFailMessage;
    }

    public void setExecuteFailMessage( String executeFailMessage ) {
        this.executeFailMessage = executeFailMessage;
    }
}