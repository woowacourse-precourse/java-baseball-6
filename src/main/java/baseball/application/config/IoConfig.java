package baseball.application.config;

import baseball.application.io.Reader;
import baseball.application.io.Writer;
import baseball.util.reader.NextStepConsoleReader;
import baseball.util.writer.SystemConsoleWriter;

public class IoConfig {

    public Reader reader() {
        return new NextStepConsoleReader();
    }

    public Writer writer() {
        return new SystemConsoleWriter();
    }
}
