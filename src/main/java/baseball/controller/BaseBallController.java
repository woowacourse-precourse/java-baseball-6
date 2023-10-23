package baseball.controller;

import baseball.model.RandomNumbers;
import baseball.model.Strikes;
import baseball.model.UserInputNumbers;
import baseball.util.GameConstant;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private RandomNumbers randomNumbers;
    private UserInputNumbers userInputNumbers;

    public void game() {
        do {
            play();
        } while (inputView.askForNewGameOrEnd() != GameConstant.END_GAME_CODE);
    }

    public void play() {
        int strikeCount, ballCount;
        randomNumbers = new RandomNumbers();
        outputView.printStartGame();
        outputView.askForNumber();
        do {
            String userInput = inputView.inputNumber();
            userInputNumbers = new UserInputNumbers(userInput);
            strikeCount = new Strikes(randomNumbers, userInputNumbers).getStrikeCount();
            ballCount = userInputNumbers.countBalls(randomNumbers);
            outputView.printCountForBallsAndStrikes(ballCount, strikeCount);
        } while (strikeCount != GameConstant.GAME_END_STRIKE_COUNT);
        outputView.printEndGame();
    }
}
