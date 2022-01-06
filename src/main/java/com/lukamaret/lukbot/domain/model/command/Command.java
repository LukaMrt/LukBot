package com.lukamaret.lukbot.domain.model.command;

public interface Command {

    String getName();

    void execute(long authorId, long channelId, String[] args);

}
