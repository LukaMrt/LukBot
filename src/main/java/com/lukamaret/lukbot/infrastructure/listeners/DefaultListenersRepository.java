package com.lukamaret.lukbot.infrastructure.listeners;

import com.google.inject.Injector;
import com.lukamaret.lukbot.ui.listeners.CommandsListener;
import com.lukamaret.lukbot.ui.listeners.SpotifyTrackerMessageListener;
import org.javacord.api.DiscordApi;

public class DefaultListenersRepository {

    private final Injector injector;

    public DefaultListenersRepository(Injector injector) {
        this.injector = injector;
    }

    public void registerListeners() {

        DiscordApi discord = injector.getInstance(DiscordApi.class);
        discord.addListener(injector.getInstance(SpotifyTrackerMessageListener.class));
        discord.addListener(new CommandsListener(injector));

    }

}
