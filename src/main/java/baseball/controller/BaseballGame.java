package baseball.controller;

import baseball.model.GameNumber;
import baseball.model.GameResult;
import baseball.util.GenerateRandomNumbers;
import baseball.util.NumberValidator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    private static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    private int strikeCount;
    private int ballCount;

    InputView inputView = new InputView();
    GenerateRandomNumbers generateRandomNumbers = new GenerateRandomNumbers();
    NumberValidator numberValidator = new NumberValidator();

    public void startGame() {
        GameNumber gameNumber = new GameNumber();
        List<Integer> getRandomNumbers = generateRandomNumbers.getRandomNumbers();
        gameNumber.setComputerNumbers(getRandomNumbers);
        System.out.println(getRandomNumbers);

        String inputNumber = inputView.readGameNumber();
        gameNumber.setPlayerNumbers(numberValidator.toValidateData(inputNumber));

        List<Integer> playerNumbers = gameNumber.getPlayerNumbers();
        List<Integer> computerNumbers = gameNumber.getComputerNumbers();

        GameResult result;
        result = compareNumbers(playerNumbers, computerNumbers);
        OutputView.printResult(result);
    }

    public GameResult compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        for (int i = 0; i < BASEBALL_GAME_NUMBER_LENGTH; i++) {
            countStrike(computerNumbers.get(i), playerNumbers.get(i));
            countBall(computerNumbers, playerNumbers.get(i), i);
        }
        return new GameResult(ballCount, strikeCount);
    }

    private void countStrike(int computerNumber, int playerNumber) {
        if (computerNumber == playerNumber) {
            strikeCount++;
        }
    }

    private void countBall(List<Integer> computerNumbers, int playerNumber, int numberIndex) {
        if (computerNumbers.get(numberIndex) != playerNumber && computerNumbers.contains(playerNumber)) {
            ballCount++;
        }
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

}
