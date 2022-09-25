import reader.Reader;

import java.io.IOException;

public class MainStarter {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        System.out.println(reader.read().size());

    }
}
