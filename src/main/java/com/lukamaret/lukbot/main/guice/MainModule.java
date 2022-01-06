package com.lukamaret.lukbot.main.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.lukamaret.lukbot.domain.application.configuration.DiscordConfiguration;
import com.lukamaret.lukbot.domain.application.configuration.SpotifyConfiguration;
import com.lukamaret.lukbot.domain.application.message.MessageSender;
import com.lukamaret.lukbot.domain.application.spotify.SpotifyTrackerMessageRepository;
import com.lukamaret.lukbot.message.DiscordMessageSender;
import com.lukamaret.lukbot.infrastructure.spotify.DefaultSpotifyTrackerMessageRepository;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

public class MainModule extends AbstractModule {

    private final SpotifyConfiguration spotifyConfiguration;
    private final DiscordConfiguration discordConfiguration;
    private final DiscordApi discord;

    public MainModule(Injector configurationInjector) {

        this.spotifyConfiguration = configurationInjector.getInstance(SpotifyConfiguration.class);
        this.discordConfiguration = configurationInjector.getInstance(DiscordConfiguration.class);

        this.discord = new DiscordApiBuilder()
                .setToken(discordConfiguration.getToken())
                .login()
                .join();
    }

    @Override
    protected void configure() {
        bind(DiscordApi.class).toInstance(discord);
        bind(SpotifyConfiguration.class).toInstance(spotifyConfiguration);
        bind(DiscordConfiguration.class).toInstance(discordConfiguration);
        bind(SpotifyTrackerMessageRepository.class).to(DefaultSpotifyTrackerMessageRepository.class);
        bind(MessageSender.class).to(DiscordMessageSender.class);
    }

}
