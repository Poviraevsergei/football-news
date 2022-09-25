package writers;

import java.io.FileWriter;
import java.io.IOException;

public class WriteHeadlines {
    public void writeHeadlines(String headline) throws IOException {
        FileWriter writer = new FileWriter("D:/development/football-news/src/main/resources/headlines.txt",true);
        writer.write("||" + headline);
        writer.close();
    }
}