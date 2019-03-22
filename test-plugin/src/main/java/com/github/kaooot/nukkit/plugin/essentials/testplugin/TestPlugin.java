package com.github.kaooot.nukkit.plugin.essentials.testplugin;

import cn.nukkit.plugin.PluginBase;
import com.github.kaooot.nukkit.plugin.essentials.testplugin.listener.PlayerJoinListener;
import com.github.kaooot.nukkit.plugin.essentials.api.PocketEssentialsAPI;
import lombok.Getter;

public class TestPlugin extends PluginBase {

    @Getter
    private PocketEssentialsAPI pocketEssentialsAPI;

    @Override
    public void onEnable() {
        this.pocketEssentialsAPI = new PocketEssentialsAPI();

        this.getServer().getPluginManager().registerEvents( new PlayerJoinListener( this ), this );
    }
}