package baseball.controller;

import baseball.dto.RoundResultDto;
import baseball.model.ComputerNumber;
import baseball.model.UserNumber;
import baseball.service.GameManager;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class MainController {
    public static MainController instance = new MainController(InputView.getInstance(), OutputView.getInstance(), GameRestartController.getInstance());
    private final InputView inputView;
    private final OutputView outputView;
    private final GameRestartController gameRestartController;
    private GameManager gameManager;

    private MainController(InputView inputView, OutputView outputView, GameRestartController gameRestartController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameRestartController = gameRestartController;
    }

    public static MainController getInstance() {
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
        return gameRestartController.wantsRestart();
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
}