package baseball;

import static baseball.Constants.ALERT_INPUT;
import static baseball.Constants.ALERT_START;

public class Baseball {
    private final Answer answer = new Answer();
    private InputNumbers inputNumbers = new InputNumbers();

    public void run() {
        start();
        game();
        end();
    }

    private void start() {
        pickAnswerNumbers();
        alertStart();
    }

    private void game() {
        alertInput();
        readInputNumbers();
    }

    private void pickAnswerNumbers() {
        answer.pickAnswerNumbers();
    }

    private void alertStart() {
        System.out.println(ALERT_START);
    }

    private void alertInput() {
        System.out.print(ALERT_INPUT);
    }

    private void readInputNumbers() {
        inputNumbers.readInput();
    }
}
