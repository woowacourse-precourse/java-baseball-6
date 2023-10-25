package baseball.controller;

import baseball.validation.Validation;
import baseball.view.Input;
import baseball.view.Output;

import java.util.List;

import static baseball.util.Number.*;

public class GameController {
    private final Input input = new Input();
    private final Output output = new Output();
    private final User user = new User();
    private final Random random = new Random();
    private final Validation validation = new Validation();

    private List<Integer> computerNumbers;

    public GameController() {
        output.printStartGame();
    }

    public void startGame() {
        int gameControlNum = RESTART_NUM;
        computerNumbers = random.generateRandomNumber();

        while (gameControlNum == RESTART_NUM) {
            input.printInputMsg();
            String userInput = user.getInputNumber();
            List<Integer> userNumbers = validation.validateInputNum(userInput);

            ResultCount result = compareNumber(computerNumbers, userNumbers);
            int ball = result.ballCount;
            int strike = result.strikeCount;
            output.printResult(ball, strike);

            gameControlNum = checkStrikeCount(strike);
        }
    }

    private static class ResultCount {
        int ballCount;
        int strikeCount;

        public ResultCount(int ballCount, int strikeCount) {
            this.ballCount = ballCount;
            this.strikeCount = strikeCount;
        }
    }

    private ResultCount compareNumber(List<Integer> computerNumbers, List<Integer> userNums) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < INPUT_LENGTH; i++) {
            int computerNum = computerNumbers.get(i);
            int userNum = userNums.get(i);

            if (computerNum == userNum) {
                strike++;
                continue;
            }

            if (computerNumbers.contains(userNum)) {
                ball++;
            }
        }

        return new ResultCount(ball, strike);
    }

    private int checkStrikeCount(int strike) {
        int gameControlInput = RESTART_NUM;

        if (strike == STRIKE_OUT) {
            output.printSuccessGame();
            gameControlInput = Integer.parseInt(user.getInputNumber());
            validation.validateGameControlInput(gameControlInput);

            checkRestartAndMakeRandomNumber(gameControlInput);
        }

        return gameControlInput;
    }

    private void checkRestartAndMakeRandomNumber(int gameControlInput) {
        if (gameControlInput == RESTART_NUM) {
            computerNumbers = random.generateRandomNumber();
        }
    }

}
