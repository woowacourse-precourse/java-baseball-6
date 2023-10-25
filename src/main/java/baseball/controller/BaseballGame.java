package baseball.controller;

import baseball.model.GameNumber;
import baseball.model.GameResult;
import baseball.util.GenerateRandomNumbers;
import baseball.util.NumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;
import java.util.Objects;

public class BaseballGame {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private static final String RESTART = "1";
    private static

    InputView inputView = new InputView();
    GenerateRandomNumbers generateRandomNumbers = new GenerateRandomNumbers();
    NumberValidator numberValidator = new NumberValidator();
    GameNumber gameNumber = new GameNumber();

    public void startGame() {
        OutputView.printStartGame();
        do {
            initComputerNumbers();
            oneGame();
        } while (restart());
    }

    private void initComputerNumbers() {
        List<Integer> getRandomNumbers = generateRandomNumbers.getRandomNumbers();
        gameNumber.setComputerNumbers(getRandomNumbers);
    }

    private void oneGame() {
        GameResult result;
        do {
            String inputNumber = inputView.readGameNumber();
            gameNumber.setPlayerNumbers(numberValidator.toValidateData(inputNumber));
            List<Integer> playerNumbers = gameNumber.getPlayerNumbers();
            List<Integer> computerNumbers = gameNumber.getComputerNumbers();
            result = compareNumbers(playerNumbers, computerNumbers);
            OutputView.printResult(result);
        } while (!result.isSuccess());
        OutputView.printEndGame();
    }

    private GameResult compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int ballCount = countBall(playerNumbers, computerNumbers);
        int strikeCount = countStrike(playerNumbers, computerNumbers);

        return new GameResult(ballCount, strikeCount);
    }

    private int countStrike(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i) == playerNumbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        int ballCount = 0;
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            if (computerNumbers.get(i) != playerNumbers.get(i) && computerNumbers.contains(playerNumbers.get(i))) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private boolean restart() {
        return Objects.equals(InputView.readRestartOrEndGame(), RESTART);
    }
}
