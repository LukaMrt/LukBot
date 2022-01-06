package com.lukamaret.lukbot.domain.application.spotify;

import com.lukamaret.lukbot.domain.application.configuration.DiscordConfiguration;
import com.lukamaret.lukbot.domain.application.message.MessageSender;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class SpotifyTrackerGuardService {

    @Inject
    private SpotifyTrackerMessageRepository spotifyTrackerMessageRepository;

    @Inject
    private DiscordConfiguration discordConfiguration;

    @Inject
    private MessageSender messageSender;

    public void messageReceived() {
        spotifyTrackerMessageRepository.updateMessage(LocalDateTime.now());
    }

    public void checkDisconnection() {

        if (spotifyTrackerMessageRepository.getLastMessage().isAfter(LocalDateTime.now().minusMinutes(5))) {
            return;
        }

        messageSender.sendMessageWithMention(
                discordConfiguration.getOwner(),
                discordConfiguration.getLogs(),
                "Spotify tracker is disconnected"
        );
    }

}
