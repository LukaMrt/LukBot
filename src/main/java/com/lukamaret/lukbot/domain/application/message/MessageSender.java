package com.lukamaret.lukbot.domain.application.message;

public interface MessageSender {

    void sendPrivateMessage(String userId, String message);

    void sendMessageWithMention(String userId, String logChannel, String message);

}
