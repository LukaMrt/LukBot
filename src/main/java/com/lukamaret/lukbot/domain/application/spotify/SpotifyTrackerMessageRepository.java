package com.lukamaret.lukbot.domain.application.spotify;

import java.time.LocalDateTime;

public interface SpotifyTrackerMessageRepository {

    LocalDateTime getLastMessage();

    void updateMessage(LocalDateTime lastMessage);

}
