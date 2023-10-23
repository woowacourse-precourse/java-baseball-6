package baseball.application.context;

import baseball.application.config.IoConfig;
import baseball.application.io.Reader;
import baseball.application.io.Writer;

public class IoContext {

    private final Writer writer;
    private final Reader reader;

    public IoContext(IoConfig config) {
        this.writer = config.writer();
        this.reader = config.reader();
    }

    public String readLine() {
        return reader.readLine();
    }

    public void println(String message) {
        writer.println(message);
    }

    public void print(String message) {
        writer.print(message);
    }
}
