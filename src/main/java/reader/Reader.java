package reader;

import model.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Reader {
    private final static String MAIN_PATH = "https://www.euro-football.ru/league_champions/news";

    public ArrayList<News> read() throws IOException {
        Document doc = allInfoReader(MAIN_PATH);
        return fillingNewsList(doc);
    }

    private Document allInfoReader(String path) throws IOException {
        return Jsoup.connect(path)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .followRedirects(true)
                .get();
    }

    private ArrayList<News> fillingNewsList(Document doc) throws IOException {
        ArrayList<News> list = new ArrayList<>();
        Elements listNews = doc.select("div.additional-content__list");
        for (Element element : listNews.select("div.additional-content-item")) {
            String title = element.select("a.additional-content-item__content-title").html().trim();
            String photoPath = element.select("a.additional-content-item__photo").select("img").attr("src");
            String newsPath = "https://www.euro-football.ru" + element.select("a.additional-content-item__content-title").attr("href");
            String text = readTextFromPath(newsPath);
            list.add(new News(title, photoPath, text));
        }
        return list;
    }

    private String readTextFromPath(String path) throws IOException {
        Document doc = allInfoReader(path);
        return doc.select("div.article__text").select("p").html();
    }
}