package com.lukamaret.lukbot.ui.commands;

import com.lukamaret.lukbot.domain.model.command.Command;
import org.javacord.api.DiscordApi;

import javax.inject.Inject;

public class PingCommand implements Command {

    @Inject
    private DiscordApi discord;

    @Override
    public String getName() {
        return "ping";
    }

    @Override
    public void execute(long authorId, long channelId, String[] args) {
        discord.getTextChannelById(channelId).ifPresent(channel -> channel.sendMessage("Pong!"));
    }

}
