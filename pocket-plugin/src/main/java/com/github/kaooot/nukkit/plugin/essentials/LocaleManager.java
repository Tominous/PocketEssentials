package com.github.kaooot.nukkit.plugin.essentials;

import cn.nukkit.utils.TextFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class LocaleManager {

    private Properties properties = new Properties();
    private InputStream inputStream;

    public String translate( String defaultLocale, String key, Object... args ) {
        try {
            if ( defaultLocale.equals( "en_US" ) ) {
                this.inputStream = this.getClass().getResourceAsStream( "/en_US.properties" );
            }
            InputStreamReader inputStreamReader = new InputStreamReader( this.inputStream );
            BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

            this.properties.load( bufferedReader );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return String.format( TextFormat.colorize( '&', this.properties.getProperty( key ) ), args );
    }
}