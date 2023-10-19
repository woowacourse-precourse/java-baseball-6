package baseball.application;

import baseball.domain.Computer;
import baseball.domain.GameProcessStatus;
import baseball.domain.User;
import baseball.io.InputProcessor;
import baseball.io.OutputProcessor;

import java.util.List;

public class GameManager {
    private final Computer computer;
    private final User user;
    private GameProcessStatus gameProcessStatus;

    public GameManager() {
        computer = Computer.init();
        user = new User();
        gameProcessStatus = GameProcessStatus.GAME_RUNNING;
    }

    public void run() {
        // 게임 시작
        OutputProcessor.printGameStart();

        while (gameProcessStatus.isGameInProgress()) {
            // Baseball 입력
            readUserBaseballs();
        }
    }

    private void readUserBaseballs() {
        final List<Integer> balls = InputProcessor.readUserBaseballs();
        user.applyBaseball(balls);
    }
}
