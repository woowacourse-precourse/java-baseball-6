package baseball.input;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
    private static final InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    private static BufferedReader br;

    private Console() {

    }

    public static String readLine() throws IOException {
        return getInstance().readLine();
    }

    public static void close() throws IOException {
        if (br != null) {
            br.close();
            inputStreamReader.close();
            br = null;
        }
    }

    private static BufferedReader getInstance() {
        if (br == null) {
            br = new BufferedReader(inputStreamReader);
        }
        return br;
    }
}
