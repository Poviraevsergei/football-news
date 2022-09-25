package filter;

import model.News;
import reader.ReadHeadlines;
import writers.WriteHeadlines;

import java.io.IOException;
import java.util.ArrayList;

public class BeforePostedFilter {
    WriteHeadlines writeHeadlines = new WriteHeadlines();
    ReadHeadlines readHeadlines = new ReadHeadlines();

    public ArrayList<News> nonPostedNews(ArrayList<News> allNews, ArrayList<String> beforePostedHeadLines) throws IOException {
        ArrayList<News> resultNews = new ArrayList<>();
        for (News news : allNews) {
            if (news.getTitle().contains("​")) {
                news.setTitle(news.getTitle().substring(1));
            }
            if (!beforePostedHeadLines.contains(news.getTitle())) {
               resultNews.add(news);
               writeHeadlines.writeHeadlines(news.getTitle());
            }
        }
        return resultNews;
    }
}