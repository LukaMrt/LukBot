package com.lukamaret.lukbot.infrastructure.configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lukamaret.lukbot.domain.application.configuration.DiscordConfiguration;
import com.lukamaret.lukbot.domain.application.configuration.SpotifyConfiguration;
import com.lukamaret.lukbot.domain.model.configuration.Configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class GsonConfiguration implements SpotifyConfiguration, DiscordConfiguration {

    public static final Gson GSON = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    private final Configuration configuration;
    private final File file;

    public GsonConfiguration(File file) {
        this.file = file;
        Configuration configuration = null;
        try {
            configuration = GSON.fromJson(new FileReader(file), Configuration.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            configuration = new Configuration();
        } finally {
            this.configuration = configuration;
        }
    }

    @Override
    public String getTracker() {
        return configuration.getSpotify().getTracker();
    }

    @Override
    public String getToken() {
        return configuration.getDiscord().getToken();
    }

    @Override
    public String getLogs() {
        return configuration.getDiscord().getLogs();
    }

    @Override
    public String getOwner() {
        return configuration.getDiscord().getOwner();
    }

    public void save() {

        try {
            FileWriter writer = new FileWriter(file);
            GSON.toJson(configuration, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
