package com.lukamaret.lukbot.ui.tasks;

import com.lukamaret.lukbot.domain.application.spotify.SpotifyTrackerGuardService;

import javax.inject.Inject;
import java.util.TimerTask;

public class SpotifyGuardTask extends TimerTask {

    @Inject
    private SpotifyTrackerGuardService spotifyTrackerGuardService;

    @Override
    public void run() {

        spotifyTrackerGuardService.checkDisconnection();

    }

}
