package baseball.controller;

import baseball.constants.BaseballConstant;
import baseball.domain.BaseballRandomNumberGenerator;
import baseball.domain.GameRestartChecker;
import baseball.domain.PlayerNumber;
import baseball.domain.ScoreCalculator;
import baseball.domain.ScoreChecker;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void baseballGame(){
        startGame();
        setUpRandomNumber();
    }
    private void startGame(){
        outputView.printGameStart();
    }

    private void setUpRandomNumber() {
        BaseballRandomNumberGenerator numberGenerator = new BaseballRandomNumberGenerator();
        List<Integer> randomNumbers = numberGenerator.generateRandomNumber();
        playGame(randomNumbers);
    }

    private void playGame(List<Integer> randomNumbers) {
        PlayerNumber playerNumber = updatePlayerNumber();
        ScoreCalculator calculator = calculateScore(randomNumbers, playerNumber);
        printScoreResult(calculator);
        checkGameOver(randomNumbers, calculator);
    }

    private void printScoreResult(ScoreCalculator calculator) {
        ScoreChecker checker = new ScoreChecker();
        checker.checkScore(outputView, calculator);
    }

    private static ScoreCalculator calculateScore(List<Integer> randomNumbers,
            PlayerNumber playerNumber) {
        ScoreCalculator calculator = new ScoreCalculator();
        calculator.calculate(randomNumbers, playerNumber.getPlayerNumbers());
        return calculator;
    }

    private PlayerNumber updatePlayerNumber() {
        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.updatePlayerNumbers(inputView.getPlayerNumber());
        return playerNumber;
    }

    private void checkGameOver(List<Integer> randomNumbers, ScoreCalculator calculator) {
        if (calculator.getStrike() != BaseballConstant.THREE_STRIKE) {
            playGame(randomNumbers);
        }
        restartYn();
    }

    private void restartYn(){
        String gameRestartYn = inputView.getGameRestartYn();
        GameRestartChecker checker = new GameRestartChecker();
        checker.updateRestartYn(gameRestartYn);
        restartGame(checker);
    }

    private void restartGame(GameRestartChecker checker) {
        if (checker.getRestartYn() == BaseballConstant.RESTART_YES) {
            setUpRandomNumber();
        }
    }
}
