package baseball.controller;

import baseball.model.Balls;
import baseball.model.RandomNumbers;
import baseball.model.Strikes;
import baseball.model.UserInputNumbers;
import baseball.util.GameConstant;
import baseball.validator.BaseballNumberInputValidation;
import baseball.validator.NewGameOrEndInputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView(
            new BaseballNumberInputValidation(),
            new NewGameOrEndInputValidation()
    );

    public void startGame() {
        do {
            play();
        } while (isGameRestartCondition());
    }

    public void play() {
        int strikeCount, ballCount;
        RandomNumbers randomNumbers = new RandomNumbers();
        outputView.printStartGame();
        outputView.askForNumber();
        do {
            String userInput = inputView.askForNumber();
            UserInputNumbers userInputNumbers = new UserInputNumbers(userInput);

            strikeCount = new Strikes(randomNumbers, userInputNumbers).getStrikeCount();
            ballCount = new Balls(randomNumbers, userInputNumbers).getBallCount();
            outputView.printCountForBallsAndStrikes(ballCount, strikeCount);
        } while (!isGameEndCondition(strikeCount));
        outputView.printEndGame();
    }

    private boolean isGameRestartCondition() {
        return inputView.askForNewGameOrEnd() == GameConstant.NEW_GAME_CODE;
    }

    private boolean isGameEndCondition(int strikeCount) {
        return strikeCount == GameConstant.GAME_END_STRIKE_COUNT;
    }
}
