package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.service.GameNumberCalculatorService;
import baseball.service.GameStatusService;
import baseball.view.GameResultView;
import baseball.view.UserInputView;
import java.util.ArrayList;
import java.util.List;

public class GamePlayController {
    private static final int STRIKE_INDEX = 0;
    private static final int THREE_STRIKE = 3;
    private final UserInputView userInputView = new UserInputView();
    private final GameResultView gameResultView = new GameResultView();
    private final GameStatusService gameStatusService = new GameStatusService();
    private final GameNumberCalculatorService gameNumberCalculatorService = new GameNumberCalculatorService();
    private List<Integer> strikeAndBallCount = new ArrayList<>();
    private Computer computer = new Computer();
    private User user = new User();

    public void startGame() {
        computer.setupGameNumbers();
        while (!gameStatusService.isExitGame()) {
            inputUserNumber();
            calculateStrikeAndBallCount();
            getGameResult();
        }
    }

    public void inputUserNumber() {
        user.setUserGameNumbers(userInputView.setUserGameNumbers());
    }

    public void calculateStrikeAndBallCount() {
        strikeAndBallCount = gameNumberCalculatorService.calculateGameNumber(user.getUserGameNumbers(),
                computer.getComputerGameNumbers());
    }

    public void getGameResult() {
        if (strikeAndBallCount.get(STRIKE_INDEX) == THREE_STRIKE) {
            gameResultView.printThreeStrikeResult();
            gameStatusService.processNextGameStatus(computer);
        }
        if (strikeAndBallCount.get(STRIKE_INDEX) != THREE_STRIKE) {
            gameResultView.printNotThreeStrikeResult(strikeAndBallCount);
        }
    }

    public GamePlayController() {
        gameResultView.printCreateController();
    }
}