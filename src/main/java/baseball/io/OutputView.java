package baseball.io;

import baseball.utils.message.IOMessage;

import java.io.BufferedWriter;
import java.io.IOException;

public class OutputView {

    private final BufferedWriter writer;

    public OutputView(BufferedWriter writer) {
        this.writer = writer;
    }

    public void write(String message) {
        try {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(IOMessage.IOEXCEPTION_WHILE_RUNTIME);
        }
    }

}
