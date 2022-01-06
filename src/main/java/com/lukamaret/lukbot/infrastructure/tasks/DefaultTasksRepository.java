package com.lukamaret.lukbot.infrastructure.tasks;

import com.google.inject.Injector;
import com.lukamaret.lukbot.ui.tasks.SpotifyGuardTask;

import java.util.Timer;

public class DefaultTasksRepository {

    private final Injector injector;

    public DefaultTasksRepository(Injector injector) {
        this.injector = injector;
    }

    public void registerTasks() {
        new Timer().schedule(injector.getInstance(SpotifyGuardTask.class), 0, 5 * 60 * 1_000);
    }

}
