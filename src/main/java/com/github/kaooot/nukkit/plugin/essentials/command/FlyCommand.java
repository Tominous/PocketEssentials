package com.github.kaooot.nukkit.plugin.essentials.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import com.github.kaooot.nukkit.plugin.api.event.PlayerFlyStatusChangeEvent;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class FlyCommand extends Command {

    private PocketEssentials plugin;

    public FlyCommand( PocketEssentials plugin, String name, String description ) {
        super( name );
        this.plugin = plugin;
        this.description = description;
        this.commandParameters.clear();
        this.commandParameters.put( "fly", new CommandParameter[] {
                new CommandParameter( "affected", true, CommandParameter.ARG_TYPE_TARGET )
        } );
    }

    @Override
    public boolean execute( CommandSender commandSender, String s, String[] arguments ) {
        if ( ! (commandSender instanceof Player) && arguments.length == 0 ) {
            commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-playerNotFound" ) );
        } else if ( commandSender instanceof Player ) {
            if ( commandSender.isOp() ) {
                if ( arguments.length != 0 ) {
                    Player affectedPlayer = this.plugin.getServer().getPlayer( arguments[0] );

                    for ( Player players : this.plugin.getServer().getOnlinePlayers().values() ) {
                        if ( ! arguments[0].equalsIgnoreCase( players.getName() ) ) {
                            commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-playerNotFound" ) );
                            return false;
                        }
                    }

                    affectedPlayer.setAllowFlight( ! affectedPlayer.getAllowFlight() );
                    commandSender.sendMessage( ! affectedPlayer.getAllowFlight() ? this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-fly-fail", affectedPlayer.getDisplayName() ) : this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-fly-success", affectedPlayer.getDisplayName() ) );

                    PlayerFlyStatusChangeEvent playerFlyStatusChangeEvent = new PlayerFlyStatusChangeEvent( affectedPlayer, affectedPlayer.getAllowFlight() );
                    this.plugin.getServer().getPluginManager().callEvent( playerFlyStatusChangeEvent );
                } else {
                    ((Player) commandSender).setAllowFlight( ! ((Player) commandSender).getAllowFlight() );
                    commandSender.sendMessage( ! ((Player) commandSender).getAllowFlight() ? this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-fly-fail", ((Player) commandSender).getDisplayName() ) : this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-fly-success", ((Player) commandSender).getDisplayName() ) );

                    PlayerFlyStatusChangeEvent playerFlyStatusChangeEvent = new PlayerFlyStatusChangeEvent( ((Player) commandSender), ((Player) commandSender).getAllowFlight() );
                    this.plugin.getServer().getPluginManager().callEvent( playerFlyStatusChangeEvent );
                }
            } else {
                commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-noPerm" ) );
                this.plugin.getLogger().info( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-noPerm-console", commandSender.getName() ) );
            }
        }
        return false;
    }
}