import bots.TelegramBot;
import filter.BeforePostedFilter;
import model.News;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import reader.ReadHeadlines;
import reader.Reader;
import writers.TelegramWriter;

import java.io.IOException;
import java.util.ArrayList;

public class MainStarter {
    public static void main(String[] args) throws Exception {
        ArrayList<News> allNews = new Reader().read();
        ArrayList<String> beforePostedHeadLines = new ReadHeadlines().readHeadlines();
        ArrayList<News> resultNews = new BeforePostedFilter().nonPostedNews(allNews, beforePostedHeadLines);
        if (!resultNews.isEmpty()) {
            new TelegramWriter().sendNews(resultNews);
        }
    }
}
