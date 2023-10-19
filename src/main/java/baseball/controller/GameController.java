package baseball.controller;

import baseball.service.GameProgress;
import baseball.service.RandomNumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;
import java.util.Map;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final GameProgress gameProgress;
    private final RandomNumberGenerator randomNumberGenerator;
    private final String STRIKE = "strike";
    private final String BALL = "ball";

    public GameController(InputView inputView, OutputView outputView, GameProgress gameProgress, RandomNumberGenerator randomNumberGenerator) {

        this.inputView = inputView;
        this.outputView = outputView;
        this.gameProgress = gameProgress;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void startGame() {
        boolean continueGame = true;

        outputView.printStartGame();

        while (continueGame) {
            List<Integer> computerNumbers = randomNumberGenerator.generateRandomNumber();
            System.out.println(computerNumbers);
            Map<String, Integer> compareNumbers = Map.of(STRIKE, 0, BALL, 0);

            while (!gameProgress.isEndGame(compareNumbers)) {

                outputView.printInputNumber();
                List<Integer> userInputNumber = inputView.userInputNumber();
                compareNumbers = gameProgress.compareNumbers(computerNumbers, userInputNumber);
                outputView.printGameProgress(compareNumbers.get(STRIKE), compareNumbers.get(BALL));
            }

            outputView.printDecideGame();
            outputView.printRestartGame();
            continueGame = gameProgress.decideGameRestart(inputView.decideGameActionInput());
        }
    }
}
