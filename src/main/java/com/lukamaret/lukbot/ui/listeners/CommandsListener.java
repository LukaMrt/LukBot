package com.lukamaret.lukbot.ui.listeners;

import com.google.inject.Injector;
import com.lukamaret.lukbot.domain.model.command.Command;
import com.lukamaret.lukbot.ui.commands.PingCommand;
import com.lukamaret.lukbot.ui.commands.StopCommand;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import java.util.Arrays;
import java.util.List;

public class CommandsListener implements MessageCreateListener {

    private final List<Command> commands;

    public CommandsListener(Injector injector) {
        this.commands = List.of(
                injector.getInstance(StopCommand.class),
                injector.getInstance(PingCommand.class)
        );
    }

    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        if (event.getMessageAuthor().isBotUser()) {
            return;
        }

        if (!event.getMessageContent().startsWith("*")) {
            return;
        }

        String[] content = event.getMessageContent().split(" ");
        String commandName = content[0].substring(1);
        long authorId = event.getMessageAuthor().getId();
        long channelId = event.getChannel().getId();
        String[] args = Arrays.copyOfRange(content, 1, content.length);

        this.commands.stream()
                .filter(command -> command.getName().equals(commandName))
                .forEach(command -> command.execute(authorId, channelId, args));
    }

}
