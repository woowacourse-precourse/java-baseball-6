package baseball;

import baseball.application.GameExecutor;
import baseball.domain.GameSetting;
import baseball.service.InputService;
import baseball.service.PrintService;

import static baseball.constant.GameConstant.*;

public class BaseBallGame {

    private final GameSetting gameSetting;
    private final GameExecutor gameExecutor;

    public BaseBallGame() {
        InputService inputService = new InputService();
        PrintService printService = new PrintService();
        this.gameSetting = new GameSetting(SIZE, START_NUMBER, END_NUMBER, EXIT_NUMBER, RESTART_NUMBER, inputService, printService);
        this.gameExecutor = new GameExecutor();
    }

    public void playGame() {
        gameExecutor.playGame(gameSetting);
    }
}
