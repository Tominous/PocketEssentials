package com.github.kaooot.nukkit.plugin.essentials.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class FeedCommand extends Command {

    private PocketEssentials plugin;

    public FeedCommand( PocketEssentials plugin, String name, String description ) {
        super( name );
        this.plugin = plugin;
        this.description = description;
        this.commandParameters.clear();
        this.commandParameters.put( "feed", new CommandParameter[] {
            new CommandParameter( "affected", true, CommandParameter.ARG_TYPE_PLAYER )
        } );
    }

    @Override
    public boolean execute( CommandSender commandSender, String s, String[] arguments ) {
        if ( ! (commandSender instanceof Player) && arguments.length == 0 ) {
            commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-playerNotFound" ) );
        }
        else if ( commandSender instanceof Player ) {
            if ( commandSender.isOp() ) {
                if ( arguments.length != 0 ) {
                    Player affectedPlayer = this.plugin.getServer().getPlayer( arguments[0] );

                    for ( Player players : this.plugin.getServer().getOnlinePlayers().values() ) {
                        if ( ! arguments[0].equalsIgnoreCase( players.getName() ) ) {
                            commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-playerNotFound" ) );
                            return false;
                        }
                    }

                    if ( affectedPlayer.getFoodData().getLevel() != affectedPlayer.getFoodData().getMaxLevel() ) {
                        affectedPlayer.getFoodData().setLevel( affectedPlayer.getFoodData().getMaxLevel() );
                        affectedPlayer.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-feed-success" ) );
                        commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-feed-success-other", affectedPlayer.getDisplayName() ) );
                    }
                } else {
                    if ( ((Player) commandSender).getFoodData().getLevel() != ((Player) commandSender).getFoodData().getMaxLevel() ) {
                        ((Player) commandSender).getFoodData().setLevel( ((Player) commandSender).getFoodData().getMaxLevel() );
                        commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-feed-success" ) );
                    }
                }
            } else {
                commandSender.sendMessage( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-noPerm" ) );
                this.plugin.getLogger().info( this.plugin.getLocaleManager().translate( this.plugin.getLocaleConfig().getDefaultLocale(), "message-command-noPerm-console", commandSender.getName() ) );
            }
        }
        return false;
    }
}