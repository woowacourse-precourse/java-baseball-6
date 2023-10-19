package baseball.application;

import baseball.domain.Computer;
import baseball.domain.GameProcessStatus;
import baseball.domain.User;

public class GameManager {
    private Computer computer;
    private User user;
    private GameProcessStatus gameProcessStatus;

    public GameManager() {
        computer = Computer.init();
        user = new User();
        gameProcessStatus = GameProcessStatus.GAME_RUNNING;
    }
}
