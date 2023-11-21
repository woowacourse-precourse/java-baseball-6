package baseball.controller;

import baseball.dto.RoundResultDto;
import baseball.model.UserNumber;
import baseball.service.GameManager;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class GamePlayController {
    private static GamePlayController instance = new GamePlayController(InputView.getInstance(), OutputView.getInstance());
    private final InputView inputView;
    private final OutputView outputView;
    private GameManager gameManager;

    public GamePlayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static GamePlayController getInstance() {
        return instance;
    }

    public boolean playRound() {
        outputView.printStart();
        initializeGameManager();
        boolean needsNextRound = true;
        while (needsNextRound) {
            UserNumber userNumber = readUserNumber();
            needsNextRound = playRound(userNumber);
            printRoundResult();
        }
        return needsNextRound;
    }

    private void initializeGameManager() {
        gameManager = GameManager.create();
    }

    private UserNumber readUserNumber() {
        List<Integer> numbers = inputView.readUserNumber();
        return UserNumber.from(numbers);
    }

    private boolean playRound(UserNumber userNumber) {
        return gameManager.playRound(userNumber);
    }

    private void printRoundResult() {
        RoundResultDto resultDto = gameManager.createResultDto();
        outputView.printResult(resultDto.isNothing(), resultDto.getBallCount(), resultDto.getStrikeCount());
    }
}