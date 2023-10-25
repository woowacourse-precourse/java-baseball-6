package baseball.receiver;

import java.io.BufferedReader;
import java.io.IOException;

public class ConsoleGameReceiver implements GameReceiver {

    private final BufferedReader receiver;

    public ConsoleGameReceiver(BufferedReader receiver) {
        this.receiver = receiver;
    }

    @Override
    public String receive() throws IOException {
        return receiver.readLine();
    }
}
