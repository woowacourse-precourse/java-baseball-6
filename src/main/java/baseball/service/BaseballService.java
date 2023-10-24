package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Result;
import baseball.exception.InputValidator;

public class BaseballService {
    private Computer computer;
    private Player player;
    private final Result result;
    private final InputValidator inputValidator;

    public BaseballService(Result result, InputValidator inputValidator) {
        this.result = result;
        this.inputValidator = inputValidator;
    }

    public void inputAnswer(String inputAnswer) {
        inputValidator.validateAnswer(inputAnswer);
        player = new Player(inputAnswer);
    }

    public String palyGame() {
        return result.compareInputAnswerToRandomNumbers(player.getInputAnswer(), computer.getRandomNumbers());
    }

    public boolean isGameOver() {
        if (result.isGameOver()) {
            result.resetGameScore();
            return true;
        }
        return false;
    }

    public boolean replay(String inputContinue) {
        inputValidator.validateContinue(inputContinue);

        if (inputContinue.endsWith("1")) {
            computer = new Computer();
            return true;
        }

        return false;
    }

    public void turnOnComputer() {
        computer = new Computer();
    }
}