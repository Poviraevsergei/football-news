package reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReadHeadlines {
    public ArrayList<String> readHeadlines() throws IOException {
        FileReader reader = new FileReader("src/main/resources/headlines.txt");
        StringBuilder text = new StringBuilder();
        int c = -1;
        while ((c = reader.read()) != -1) {
            text.append((char) c);
        }
        reader.close();

        return (ArrayList<String>) Arrays.stream(text.toString().split("\\|\\|")).collect(Collectors.toList());
    }
}
