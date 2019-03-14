package com.github.kaooot.nukkit.plugin.essentials.command;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class GodModeCommand extends Command {

    private PocketEssentials plugin;

    @Deprecated
    public GodModeCommand( PocketEssentials plugin, String name ) {
        super( name );
        this.plugin = plugin;
        this.description = "Enables your godly powers.";
    }

    @Override
    public boolean execute( CommandSender commandSender, String s, String[] arguments ) {
        return false;
    }
}