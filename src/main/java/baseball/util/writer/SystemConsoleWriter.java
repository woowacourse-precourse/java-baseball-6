package baseball.util.writer;

import baseball.application.io.Writer;

public class SystemConsoleWriter implements Writer {

    public void println(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.print(message);
    }
}
