package baseball.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OutputStreamProvider implements AutoCloseable {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    public OutputStreamProvider() {
        System.setOut(new PrintStream(outContent));
    }

    public String getOutput() {
        return outContent.toString();
    }

    @Override
    public void close() {
        System.setOut(originalOut);
    }
}
