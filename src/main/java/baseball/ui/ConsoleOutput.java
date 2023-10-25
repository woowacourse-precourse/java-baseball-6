package baseball.ui;

import baseball.model.BallCounter;

public class ConsoleOutput implements Output {

    @Override
    public void print(Message message) {
        System.out.print(message.getMessage());
    }

    @Override
    public void print(BallCounter message) {
        System.out.println(message);
    }
}