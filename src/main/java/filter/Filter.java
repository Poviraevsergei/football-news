package filter;

import model.News;

public class Filter {
    public News checkNewsFilter(News news) {
        nbspFilter(news);
        brFilter(news);

        return news;
    }

    private News nbspFilter(News news) {
        if (news.getText().contains("&nbsp;")) {
            news.setText(news.getText().replace("&nbsp;", ""));
        }
        return news;
    }

    private News brFilter(News news) {
        if (news.getText().contains("<br>")) {
            news.setText(news.getText().replace("<br>", ""));
        }
        return news;
    }
}