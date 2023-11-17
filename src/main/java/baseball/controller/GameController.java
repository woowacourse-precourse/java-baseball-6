package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.service.GameResultService;
import baseball.model.PlayerChoice;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    public static GameController instance = new GameController();

    private GameController() {
    }

    public static GameController getInstance() {
        return instance;
    }

    public void run() {
        boolean continuePlaying = true;
        while (continuePlaying) {
            continuePlaying = play();
        }
    }

    private boolean play() {
        OutputView.printStart();
        ComputerNumber computerNumber = createComputerNumber();

        boolean needsNextRound = true;
        while (needsNextRound) {
            needsNextRound = playRound(computerNumber);
        }
        return doRestart();
    }

    private ComputerNumber createComputerNumber() {
        return ComputerNumber.create();
    }

    private boolean playRound(ComputerNumber computerNumber) {
        OutputView.printGetInput();
        String input = InputView.readInput();
        PlayerNumber playerNumber = PlayerNumber.create(input);
        GameResultService gameResultService = new GameResultService(computerNumber, playerNumber);
        OutputView.printResult(gameResultService.isNothing(), gameResultService.getBallCount(), gameResultService.getStrikeCount());
        return !gameResultService.isThreeStrike();
    }

    private static boolean doRestart() {
        OutputView.printEnd();
        String input = InputView.readInput();
        PlayerChoice playerChoice = new PlayerChoice(input);
        return playerChoice.getValue() == 1;
    }
}
