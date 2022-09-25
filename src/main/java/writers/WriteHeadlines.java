package writers;

import java.io.FileWriter;
import java.io.IOException;

public class WriteHeadlines {
    public void writeHeadlines(String headline) throws IOException {
        FileWriter writer = new FileWriter("src/main/resources/headlines.txt");
        writer.append("||" + headline);
        writer.close();
    }
}
