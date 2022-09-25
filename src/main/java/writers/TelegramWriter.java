package writers;

import bots.TelegramBot;
import filter.Filter;
import lombok.extern.slf4j.Slf4j;
import model.News;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.*;
import java.util.ArrayList;

@Slf4j
public class TelegramWriter {
    Filter filter = new Filter();

    public void sendNews(ArrayList<News> listNews) throws IOException, TelegramApiException, InterruptedException {
        TelegramBot telegramBot = new TelegramBot();

        for (News news : listNews) {
            SendPhoto sendPhoto = new SendPhoto();
            sendPhoto.setChatId("@football_shock");
            news = filter.checkNewsFilter(news);
            try {
                sendPhoto.setPhoto(new InputFile(news.getPhoto()));
                sendPhoto.setParseMode(ParseMode.MARKDOWN);
                sendPhoto.setCaption("*" + news.getTitle() + "*" + "\n".repeat(2) + news.getText());
                telegramBot.execute(sendPhoto);
                Thread.sleep(3000);
            } catch (Exception e) {
                log.info(e.getMessage() + news);
            }
        }
    }
}
