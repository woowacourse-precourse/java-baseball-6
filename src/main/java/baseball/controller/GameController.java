package baseball.controller;

import baseball.model.CompareResult;
import baseball.service.GameProgress;
import baseball.service.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameProgress gameProgress;
    private final RandomNumberGenerator randomNumberGenerator;
    private static final int INITIALIZE_NUMBER = 0;

    public GameController(InputView inputView, OutputView outputView,
                          GameProgress gameProgress,
                          RandomNumberGenerator randomNumberGenerator) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.gameProgress = gameProgress;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startGame() {

        outputView.printStartGame();

        do {
            playSingleRound();
        } while (isContinueGame());
    }

    private void playSingleRound() {

        List<Integer> computerNumbers = randomNumberGenerator.generateRandomNumber();
        CompareResult compareNumbers = initCompareNumbers();

        while (!gameProgress.isEndGame(compareNumbers)) {
            compareNumbers = playAndCompare(computerNumbers);
        }

        outputView.printDecideGame();
    }


    private CompareResult initCompareNumbers() {

        return new CompareResult(INITIALIZE_NUMBER, INITIALIZE_NUMBER);
    }

    private CompareResult playAndCompare(List<Integer> computerNumbers) {

        outputView.printInputNumber();
        List<Integer> userInputNumber = inputView.userInputNumber();
        CompareResult compareResult = gameProgress.compareNumbers(computerNumbers, userInputNumber);
        outputView.printGameProgress(compareResult.strikes(), compareResult.balls());
        return compareResult;
    }

    private boolean isContinueGame() {

        outputView.printRestartGame();
        return gameProgress.decideGameRestart(inputView.decideGameActionInput());
    }
}
