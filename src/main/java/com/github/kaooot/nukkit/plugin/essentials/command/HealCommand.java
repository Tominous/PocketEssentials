package com.github.kaooot.nukkit.plugin.essentials.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParameter;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

public class HealCommand extends Command {

    private PocketEssentials plugin;

    public HealCommand( PocketEssentials plugin, String name, String description ) {
        super( name );
        this.plugin = plugin;
        this.description = description;
        this.commandParameters.clear();
        this.commandParameters.put( "heal", new CommandParameter[] {
                new CommandParameter( "affected", true, CommandParameter.ARG_TYPE_PLAYER )
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

                    if ( affectedPlayer.getHealth() != affectedPlayer.getMaxHealth() || affectedPlayer.getFoodData().getLevel() != affectedPlayer.getFoodData().getMaxLevel() ) {
                        affectedPlayer.setHealth( affectedPlayer.getMaxHealth() );
                        affectedPlayer.getFoodData().setLevel( affectedPlayer.getFoodData().getMaxLevel() );
                        affectedPlayer.sendMessage( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-heal-success-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
                        commandSender.sendMessage( String.format( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-heal-success-other-" + this.plugin.getLocaleConfig().getDefaultLocale() ), affectedPlayer.getDisplayName() ) );
                    }
                } else {
                    if ( ((Player) commandSender).getHealth() != ((Player) commandSender).getMaxHealth() || ((Player) commandSender).getFoodData().getLevel() != ((Player) commandSender).getFoodData().getMaxLevel() ) {
                        ((Player) commandSender).setHealth( ((Player) commandSender).getMaxHealth() );
                        ((Player) commandSender).getFoodData().setLevel( ((Player) commandSender).getFoodData().getMaxLevel() );
                        commandSender.sendMessage( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-heal-success-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
                    }
                }
            } else {
                commandSender.sendMessage( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-noPerm-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
                this.plugin.getLogger().info( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-noPerm-console-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
            }
        }
        return false;
    }
}