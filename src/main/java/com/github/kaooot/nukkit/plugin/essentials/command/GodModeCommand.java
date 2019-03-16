package com.github.kaooot.nukkit.plugin.essentials.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.github.kaooot.nukkit.plugin.api.event.PlayerGodModeStatusChangeEvent;
import com.github.kaooot.nukkit.plugin.essentials.PocketEssentials;

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
            commandSender.sendMessage( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-playerNotFound-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
        } else {
            if ( commandSender.isOp() ) {
                String uuid = ((Player) commandSender).getUniqueId().toString();

                ((Player)commandSender).setHealth( ((Player)commandSender).getMaxHealth() );
                ((Player)commandSender).getFoodData().setLevel( ((Player)commandSender).getFoodData().getMaxLevel() );

                this.plugin.getPocketUserManager().getPocketUserConfig( uuid ).setGodMode( ! this.plugin.getPocketUserManager().getPocketUserConfig( uuid ).isGodMode() );
                commandSender.sendMessage( ! this.plugin.getPocketUserManager().getPocketUserConfig( uuid ).isGodMode() ? this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-godMode-fail-" + this.plugin.getLocaleConfig().getDefaultLocale() ) : this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-godMode-success-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );

                PlayerGodModeStatusChangeEvent playerGodModeStatusChangeEvent = new PlayerGodModeStatusChangeEvent( ((Player)commandSender), this.plugin.getPocketUserManager().getPocketUserConfig( uuid ).isGodMode() );
                this.plugin.getServer().getPluginManager().callEvent( playerGodModeStatusChangeEvent );
            } else {
                commandSender.sendMessage( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-noPerm-" + this.plugin.getLocaleConfig().getDefaultLocale() ) );
                this.plugin.getLogger().info( String.format( this.plugin.getLocaleConfig().getMessageFromConfiguration( "Translations.messages.message-command-noPerm-console-" + this.plugin.getLocaleConfig().getDefaultLocale() ), commandSender.getName() ) );
            }
        }
        return false;
    }
}