package baseball.controller;

import baseball.member.ComputerNumbers;
import baseball.member.PlayerNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    public static final int GAME_NUMBER_DIGIT = 3;
    private PlayerNumbers playerNumbers;
    private ComputerNumbers computerNumbers;
    private final RestartService restartService;
    private final StrikeBallCountService strikeBallCountService;

    public BaseballGameController(StrikeBallCountService strikeBallCountService, RestartService restartService) {
        this.strikeBallCountService = strikeBallCountService;
        this.restartService = restartService;
    }

    public void playBaseballGame() {
        OutputView.printGameStartMessage();
        do {
            playOneBaseballGame();
        } while (wantsToRestartGame());
    }

    private void playOneBaseballGame() {
        setComputerNumbers();
        do {
            inputPlayerNumbers();
            strikeBallCountService.countStrikeAndBall(playerNumbers, computerNumbers);
        } while (!strikeBallCountService.isGameClear());
    }

    private void setComputerNumbers() {
        this.computerNumbers = new ComputerNumbers();
    }

    private void inputPlayerNumbers() {
        this.playerNumbers = new PlayerNumbers(InputView.inputPlayerNumbers());
    }

    private boolean wantsToRestartGame() {
       return restartService.chooseRestartOption(InputView.inputRestartOption());
    }
}
