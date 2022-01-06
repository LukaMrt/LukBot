package com.lukamaret.lukbot.message;

import com.lukamaret.lukbot.domain.application.message.MessageSender;
import org.javacord.api.DiscordApi;

import javax.inject.Inject;

public class DiscordMessageSender implements MessageSender {

    @Inject
    private DiscordApi discord;

    @Override
    public void sendPrivateMessage(String userId, String message) {

        discord.getUserById(userId).thenAccept(user -> user.sendMessage(message));

    }

    @Override
    public void sendMessageWithMention(String userId, String logChannel, String message) {

        discord.getTextChannelById(logChannel)
                .ifPresent(channel -> channel.sendMessage("<@" + userId + "> : " + message));

    }

}
