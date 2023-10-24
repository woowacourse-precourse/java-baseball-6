package baseball.io;

import baseball.utils.message.IOMessage;

import java.io.BufferedReader;
import java.io.IOException;

public class InputView {

    private final BufferedReader reader;

    public InputView(BufferedReader reader) {
        this.reader = reader;
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(IOMessage.IOEXCEPTION_WHILE_RUNTIME);
        }
    }



}
