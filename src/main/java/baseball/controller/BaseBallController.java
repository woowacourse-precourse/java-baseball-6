package baseball.controller;

import static baseball.view.InputView.END_GAME_CODE;

import baseball.model.RandomNumbers;
import baseball.model.UserInputNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

    private final int GAME_END_STRIKE_COUNTS = 3;

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    private RandomNumbers randomNumbers;
    private UserInputNumbers userInputNumbers;

    public void game() {
        do {
            play();
        } while (inputView.askForNewGameOrEnd() != END_GAME_CODE);
    }

    public void play() {
        int strikeCount, ballCount;
        randomNumbers = new RandomNumbers();
        outputView.printStartGame();
        outputView.askForNumber();
        do {
            String userInput = inputView.inputNumber();
            userInputNumbers = new UserInputNumbers(userInput);
            strikeCount = userInputNumbers.countStrikes(randomNumbers);
            ballCount = userInputNumbers.countBalls(randomNumbers);
            outputView.printCountForBallsAndStrikes(ballCount, strikeCount);
        } while (strikeCount != GAME_END_STRIKE_COUNTS);
        outputView.printEndGame();
    }
}
