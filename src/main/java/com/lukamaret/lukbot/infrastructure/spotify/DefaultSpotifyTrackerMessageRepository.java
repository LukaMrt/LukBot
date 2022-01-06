package com.lukamaret.lukbot.infrastructure.spotify;

import com.lukamaret.lukbot.domain.application.spotify.SpotifyTrackerMessageRepository;

import java.time.LocalDateTime;

public class DefaultSpotifyTrackerMessageRepository implements SpotifyTrackerMessageRepository {

    private LocalDateTime localDateTime = LocalDateTime.now();

    @Override
    public LocalDateTime getLastMessage() {
        return this.localDateTime;
    }

    @Override
    public void updateMessage(LocalDateTime lastMessage) {
        this.localDateTime = lastMessage;
    }

}
