package filter;

import model.News;
import org.checkerframework.checker.units.qual.A;
import writers.WriteHeadlines;

import java.io.IOException;
import java.util.ArrayList;

public class BeforePostedFilter {
    WriteHeadlines writeHeadlines = new WriteHeadlines();

    public ArrayList<News> nonPostedNews(ArrayList<News> allNews, ArrayList<String> beforePostedHeadLines) throws IOException {
        ArrayList<News> resultNews = new ArrayList<>();
        for (News news : allNews) {
            if (!beforePostedHeadLines.contains(news.getTitle())) {
                resultNews.add(news);
                writeHeadlines.writeHeadlines(news.getTitle());
            }
        }
        return resultNews;
    }
}
