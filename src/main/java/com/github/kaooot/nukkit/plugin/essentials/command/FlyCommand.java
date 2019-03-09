package com.github.kaooot.nukkit.plugin.essentials.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.utils.TextFormat;
import com.github.kaooot.nukkit.plugin.api.event.PlayerFlyStatusChangeEvent;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class FlyCommand extends Command {

    private PocketEssentials plugin;

    public FlyCommand( PocketEssentials plugin, String name ) {
        super( name );
        this.plugin = plugin;
        this.description = "Take off, and soar!";
        this.commandParameters.clear();
        this.commandParameters.put( "fly", new CommandParameter[] {
                new CommandParameter( "affected", true, CommandParameter.ARG_TYPE_TARGET )
        } );
    }

    @Override
    public boolean execute( CommandSender commandSender, String s, String[] arguments ) {
        if ( ! (commandSender instanceof Player) && arguments.length == 0 ) {
            commandSender.sendMessage( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-playerNotFound-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
        }
        else if ( commandSender instanceof Player ) {
            if ( commandSender.isOp() ) {
                if ( arguments.length != 0 ) {
                    Player affectedPlayer = this.plugin.getServer().getPlayer( arguments[0] );

                    for ( Player players : this.plugin.getServer().getOnlinePlayers().values() ) {
                        if ( ! arguments[0].equalsIgnoreCase( players.getName() ) ) {
                            commandSender.sendMessage( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-playerNotFound-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
                            return false;
                        }
                    }

                    affectedPlayer.setAllowFlight( ! affectedPlayer.getAllowFlight() );
                    commandSender.sendMessage( ! affectedPlayer.getAllowFlight() ? String.format( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-fly-fail-" + this.plugin.getLocaleConfig().getDefaultLocale() ), affectedPlayer.getDisplayName() ) : String.format( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-fly-success-" + this.plugin.getLocaleConfig().getDefaultLocale() ), affectedPlayer.getDisplayName() ) );

                    PlayerFlyStatusChangeEvent playerFlyStatusChangeEvent = new PlayerFlyStatusChangeEvent( affectedPlayer, affectedPlayer.getAllowFlight() );
                    this.plugin.getServer().getPluginManager().callEvent( playerFlyStatusChangeEvent );
                } else {
                    ((Player) commandSender).setAllowFlight( ! ((Player) commandSender).getAllowFlight() );
                    commandSender.sendMessage( ! ((Player) commandSender).getAllowFlight() ? String.format( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-fly-fail-" + this.plugin.getLocaleConfig().getDefaultLocale() ), ((Player) commandSender).getDisplayName() ) : String.format( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-fly-success-" + this.plugin.getLocaleConfig().getDefaultLocale() ), ((Player) commandSender).getDisplayName() ) );

                    PlayerFlyStatusChangeEvent playerFlyStatusChangeEvent = new PlayerFlyStatusChangeEvent( ((Player) commandSender), ((Player) commandSender).getAllowFlight() );
                    this.plugin.getServer().getPluginManager().callEvent( playerFlyStatusChangeEvent );
                }
            } else {
                commandSender.sendMessage( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-noPerm-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
                this.plugin.getLogger().info( TextFormat.RED + commandSender.getName() + TextFormat.DARK_RED + " does not have an access to this command." );
            }
        }
        return false;
    }
}