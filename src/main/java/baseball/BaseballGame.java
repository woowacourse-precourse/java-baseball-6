package baseball;

import java.util.List;

public class BaseballGame {

    private final Computer computer;

    public BaseballGame(Computer computer) {
        this.computer = computer;
    }

    public void run() {
        List<Integer> correctAnswer = computer.createCorrectAnswer();
    }
}
