package baseball.receiver;

import java.io.BufferedReader;

public class ConsoleGameReceiver implements GameReceiver {

    private final BufferedReader receiver;

    public ConsoleGameReceiver(BufferedReader receiver) {
        this.receiver = receiver;
    }

}
