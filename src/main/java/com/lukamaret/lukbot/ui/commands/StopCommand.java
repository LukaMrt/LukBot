package com.lukamaret.lukbot.ui.commands;

import com.lukamaret.lukbot.domain.model.command.Command;
import org.javacord.api.DiscordApi;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class StopCommand implements Command {

    @Inject
    private DiscordApi discord;

    @Override
    public String getName() {
        return "stop";
    }

    @Override
    public void execute(long authorId, long channelId, String[] args) {
        discord.disconnect();
        LoggerFactory.getLogger(StopCommand.class).info("Spotify tracker stopped");
        System.exit(0);
    }

}
