package baseball.controller;

import baseball.model.Balls;
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

    public void startGame() {
        do {
            play();
        } while (gameRestartCondition());
    }

    public void play() {
        int strikeCount, ballCount;
        randomNumbers = new RandomNumbers();
        outputView.printStartGame();
        outputView.askForNumber();

        do {
            String userInput = inputView.askForNumber();
            userInputNumbers = new UserInputNumbers(userInput);

            strikeCount = new Strikes(randomNumbers, userInputNumbers).getStrikeCount();
            ballCount = new Balls(randomNumbers, userInputNumbers).getBallCount();

            outputView.printCountForBallsAndStrikes(ballCount, strikeCount);
        } while (isNotGameEndCondition(strikeCount));
        outputView.printEndGame();
    }

    private boolean gameRestartCondition() {
        return inputView.askForNewGameOrEnd() == GameConstant.NEW_GAME_CODE;
    }

    private boolean isNotGameEndCondition(int strikeCount) {
        return strikeCount != GameConstant.GAME_END_STRIKE_COUNT;
    }
}
