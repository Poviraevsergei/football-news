import filter.BeforePostedFilter;
import model.News;
import reader.ReadHeadlines;
import reader.Reader;
import writers.TelegramWriter;

import java.util.ArrayList;

public class MainStarter {
    public static void main(String[] args) throws Exception {
        //Вычитка всех новостей
        ArrayList<News> allNews = new Reader().read();

        //Вычитка старых новостей из headlines.txt
        ArrayList<String> headlinesList = new ReadHeadlines().readHeadlinesToArray();

        //Новости которые раньше не постились
        ArrayList<News> resultNews = new BeforePostedFilter().nonPostedNews(allNews, headlinesList);

        //Постинг новых новостей
        if (!resultNews.isEmpty()) {
            new TelegramWriter().sendNews(resultNews);
        }
    }
}