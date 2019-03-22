package com.github.kaooot.nukkit.plugin.essentials.config;

import cn.nukkit.utils.Config;

import java.io.File;

abstract class PocketConfig {

    File file;
    Config config;

    protected abstract void setDefaults();
    protected abstract void saveConfig();
}