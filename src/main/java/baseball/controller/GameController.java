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
    public static GameController instance = new GameController(InputView.getInstance(), OutputView.getInstance());
    private final InputView inputView;
    private final OutputView outputView;
    private GameManager gameManager;

    private GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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
        outputView.printStart();
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

    private UserNumber readUserNumber() {
        List<Integer> numbers = inputView.readUserNumber();
        return UserNumber.from(numbers);
    }

    private boolean playRound(UserNumber userNumber) {
        boolean needsNextRound;
        needsNextRound = gameManager.playRound(userNumber);
        return needsNextRound;
    }

    private void printRoundResult() {
        RoundResultDto resultDto = gameManager.createResultDto();
        outputView.printResult(resultDto.isNothing(), resultDto.getBallCount(), resultDto.getStrikeCount());
    }

    private boolean wantsRestart() {
        outputView.printEnd();
        PlayAgainDecision playAgainDecision = readPlayAgainInput();
        return playAgainDecision.isAgain();
    }

    private PlayAgainDecision readPlayAgainInput() {
        int input = inputView.readPlayAgainInput();
        return PlayAgainDecision.of(input);
    }
}