package baseball;

import static baseball.Number.getRandomNumber;
import static judge.JudgeStatus.CORRECT;
import static judge.JudgeStatus.NOTHING;

import input.Input;
import judge.Judge;
import judge.JudgeResult;
import judge.JudgeStatus;
import output.Output;

class Baseball {

    private final Input input;
    private final Judge judge;
    private final Output output;

    Baseball() {
        input = new Input();
        judge = new Judge();
        output = new Output();
    }

    void printStartMessage() {
        output.start();
    }

    GameStatus run() {
        initialize();
        play();
        return askGameOver();
    }

    private void initialize() {
        judge.initialize(getRandomNumber());
    }

    private void play() {
        JudgeStatus status = NOTHING;
        while (isUserNumberNotCorrect(status)) {
            Number userNumber = askNumber();
            JudgeResult result = resultFrom(userNumber);
            printResult(result);
            status = result.getStatus();
        }
    }

    private boolean isUserNumberNotCorrect(JudgeStatus status) {
        return !status.equals(CORRECT);
    }

    private Number askNumber() {
        output.askUserNumber();
        return input.askUserNumber();
    }

    private JudgeResult resultFrom(Number userNumber) {
        return judge.resultFrom(userNumber);
    }

    private GameStatus askGameOver() {
        return input.askGameOver();
    }

    private void printResult(JudgeResult result) {
        output.printResult(result);
    }
}
