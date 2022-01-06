package com.lukamaret.lukbot.domain.model.configuration;

public class Configuration {

    private Spotifyconfiguration spotify;

    private DiscordConfiguration discord;

    public Spotifyconfiguration getSpotify() {
        return spotify;
    }

    public DiscordConfiguration getDiscord() {
        return discord;
    }

}
