package baseball;

import static judge.JudgeStatus.CORRECT;
import static judge.JudgeStatus.NOTHING;

import camp.nextstep.edu.missionutils.Randoms;
import input.Input;
import judge.Judge;
import judge.JudgeResult;
import judge.JudgeStatus;
import output.Output;

class Baseball {

    private final Input input;
    private final Judge judge;
    private final Output output;

    private JudgeStatus status = NOTHING;

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
        status = NOTHING;
        judge.init(getComputerNumber());
    }

    private void play() {
        while (userNumberNotCorrect()) {
            Number userNumber = askNumber();
            JudgeResult result = resultFrom(userNumber);
            printResult(result);
        }
    }

    private boolean userNumberNotCorrect() {
        return !status.equals(CORRECT);
    }

    private Number askNumber() {
        output.askUserNumber();
        return input.askUserNumber();
    }

    private JudgeResult resultFrom(Number userNumber) {
        JudgeResult result = judge.resultFrom(userNumber);
        status = result.getStatus();
        return result;
    }

    private GameStatus askGameOver() {
        return input.askGameOver();
    }

    private void printResult(JudgeResult result) {
        output.printResult(result);
    }

    private Number getComputerNumber() {
        StringBuilder computer = new StringBuilder();
        while (computer.length() < 3) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            if (!computer.toString().contains(randomNumber)) {
                computer.append(randomNumber);
            }
        }
        return Number.of(computer.toString());
    }
}
