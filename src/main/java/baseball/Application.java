package baseball;

import baseball.client.Client;
import baseball.console.ConsoleHandler;

public class Application {
    public static void main(String[] args) {
        Client client = new Client(new ConsoleHandler());
        client.run();
    }
}
