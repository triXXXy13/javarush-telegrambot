package com.github.javarushcommunity.jrtb.service;


import com.github.javarushcommunity.jrtb.bot.JavarushTelegramBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBoxMessageService")
public class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private JavarushTelegramBot javarushBot;

    @BeforeEach
    public void init() {
        javarushBot = Mockito.mock(JavarushTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javarushBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        sendBotMessageService.sendMessage(chatId, message);

        Mockito.verify(javarushBot).execute(sendMessage);
    }
}
