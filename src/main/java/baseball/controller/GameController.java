package baseball.controller;

import baseball.dto.RoundResultDto;
import baseball.model.ComputerNumber;
import baseball.model.PlayAgainDecision;
import baseball.model.UserNumber;
import baseball.service.GameManager;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GameController {
    public static GameController instance = new GameController();
    private GameManager gameManager;

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
        initializeGameManager();
        boolean needsNextRound = true;
        while (needsNextRound) {
            UserNumber userNumber = readUserNumber();
            needsNextRound = playRound(userNumber);
            printRoundResult();
        }
        return wantsRestart();
    }

    private void initializeGameManager() {
        ComputerNumber computerNumber = ComputerNumber.create();
        gameManager = GameManager.from(computerNumber);
    }

    private static UserNumber readUserNumber() {
        List<Integer> numbers = InputView.readUserNumber();
        return UserNumber.from(numbers);
    }

    private boolean playRound(UserNumber userNumber) {
        boolean needsNextRound;
        needsNextRound = gameManager.playRound(userNumber);
        return needsNextRound;
    }

    private void printRoundResult() {
        RoundResultDto resultDto = gameManager.createResultDto();
        OutputView.printResult(resultDto.isNothing(), resultDto.getBallCount(), resultDto.getStrikeCount());
    }

    private static boolean wantsRestart() {
        OutputView.printEnd();
        PlayAgainDecision playAgainDecision = readPlayAgainInput();
        return playAgainDecision.isAgain();
    }

    private static PlayAgainDecision readPlayAgainInput() {
        int input = InputView.readPlayAgainInput();
        return PlayAgainDecision.of(input);
    }
}