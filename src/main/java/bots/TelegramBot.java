package bots;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "";
    }

    @Override
    public String getBotToken() {
        return "5591637751:AAHHchI6Or3KsmNy3gUCBdvJWS36lC0_H9o";
    }

    @Override
    public void onUpdateReceived(Update update) {

    }


}
