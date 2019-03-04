package com.github.kaooot.nukkit.plugin.essentials;

import cn.nukkit.plugin.PluginBase;
import com.github.kaooot.nukkit.plugin.essentials.config.LocaleConfig;

/*
 * Copyright (c) 2019, PocketEssentials and Kaooot
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */
public class PocketEssentials extends PluginBase {

    private LocaleConfig localeConfig;

    @Override
    public void onEnable() {
        this.localeConfig = new LocaleConfig( this );

        this.getLogger().info( this.localeConfig.getMessageFromConfiguration( "Translations.messages.message-onEnable-" + this.localeConfig.getDefaultLocale() ) );
    }

    @Override
    public void onDisable() {
        this.getLogger().info( this.localeConfig.getMessageFromConfiguration( "Translations.messages.message-onDisable-" + this.localeConfig.getDefaultLocale() ) );
    }
}