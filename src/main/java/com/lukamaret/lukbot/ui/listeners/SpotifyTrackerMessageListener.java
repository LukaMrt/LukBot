package com.lukamaret.lukbot.ui.listeners;

import com.lukamaret.lukbot.domain.application.configuration.SpotifyConfiguration;
import com.lukamaret.lukbot.domain.application.spotify.SpotifyTrackerGuardService;
import org.javacord.api.entity.DiscordEntity;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import javax.inject.Inject;

public class SpotifyTrackerMessageListener implements MessageCreateListener {

    @Inject
    private SpotifyConfiguration spotifyConfiguration;

    @Inject
    private SpotifyTrackerGuardService spotifyTrackerGuardService;

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        if (!event.isServerMessage()) {
            return;
        }

        String channelId = event.getServerTextChannel()
                .map(DiscordEntity::getIdAsString)
                .orElse("");

        if (!channelId.equals(spotifyConfiguration.getTracker())) {
            return;
        }

        spotifyTrackerGuardService.messageReceived();
    }

}
