package com.github.javarushcommunity.jrtb.service;

/**
 * Service for sending messages via telegram-bot.
 */
public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
}
