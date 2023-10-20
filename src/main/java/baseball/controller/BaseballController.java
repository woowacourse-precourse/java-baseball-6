package baseball.controller;

import baseball.domain.BaseballRandomNumberGenerator;
import baseball.domain.PlayerNumber;
import baseball.domain.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    public void baseballGame(){
        startGame();
        playGame();
    }
    private void startGame(){
        outputView.printGameStart();
    }
    private void playGame() {
        BaseballRandomNumberGenerator numberGenerator = new BaseballRandomNumberGenerator();
        List<Integer> randomNumbers = numberGenerator.generateRandomNumber();

        PlayerNumber playerNumber = new PlayerNumber();
        playerNumber.updatePlayerNumbers(inputView.getPlayerNumber());

        ScoreCalculator calculator = new ScoreCalculator();
        calculator.calculate(randomNumbers, playerNumber.getPlayerNumbers());
    }
}
