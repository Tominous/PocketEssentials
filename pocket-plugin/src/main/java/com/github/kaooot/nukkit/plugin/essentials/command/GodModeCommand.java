package com.github.kaooot.nukkit.plugin.essentials.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;
import com.github.kaooot.nukkit.plugin.essentials.api.event.PlayerGodModeStatusChangeEvent;

public class GodModeCommand extends Command {

    private PocketEssentials plugin;

    public GodModeCommand( PocketEssentials plugin, String name, String description ) {
        super( name );
        this.plugin = plugin;
        this.description = description;
    }

    @Override
    public boolean execute( CommandSender commandSender, String s, String[] arguments ) {
        if ( ! (commandSender instanceof Player) ) {
            commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-playerNotFound" ) );
        } else {
            if ( commandSender.isOp() ) {
                String uuid = ((Player) commandSender).getUniqueId().toString();

                ((Player) commandSender).setHealth( ((Player) commandSender).getMaxHealth() );
                ((Player) commandSender).getFoodData().setLevel( ((Player) commandSender).getFoodData().getMaxLevel() );

                this.plugin.getPocketUserManager().getPocketUserConfig( uuid ).setGodMode( ! this.plugin.getPocketUserManager().getPocketUserConfig( uuid ).isGodMode() );
                commandSender.sendMessage( ! this.plugin.getPocketUserManager().getPocketUserConfig( uuid ).isGodMode() ? this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-godMode-fail" ) : this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-godMode-success" ) );

                PlayerGodModeStatusChangeEvent playerGodModeStatusChangeEvent = new PlayerGodModeStatusChangeEvent( ((Player) commandSender), this.plugin.getPocketUserManager().getPocketUserConfig( uuid ).isGodMode() );
                this.plugin.getServer().getPluginManager().callEvent( playerGodModeStatusChangeEvent );
            } else {
                commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-noPerm" ) );
                this.plugin.getLogger().info( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-noPerm-console", commandSender.getName() ) );
            }
        }
        return false;
    }
}