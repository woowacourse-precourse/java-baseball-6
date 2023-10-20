package baseball.controller;

import baseball.domain.BaseballRandomNumberGenerator;
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
        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.updatePlayerNumbers(inputView.getPlayerNumber());

        ScoreCalculator calculator = new ScoreCalculator();
        calculator.calculate(randomNumbers, playerNumber.getPlayerNumbers());

        ScoreChecker checker = new ScoreChecker();
        checker.checkScore(outputView, calculator);

        checkGameOver(randomNumbers, calculator);
    }

    private void checkGameOver(List<Integer> randomNumbers, ScoreCalculator calculator) {
        if (calculator.getStrike() != 3) {
            playGame(randomNumbers);
        }
        restartYn();
    }

    private void restartYn(){
        inputView.getGameRestartYn();

    }


}
