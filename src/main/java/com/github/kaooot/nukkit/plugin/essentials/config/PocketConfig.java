package com.github.kaooot.nukkit.plugin.essentials.config;

import cn.nukkit.utils.Config;

import java.io.File;

public abstract class PocketConfig {

    protected File file;
    protected Config config;

    protected abstract void setDefaults();
    protected abstract void saveConfig();
}