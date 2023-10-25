package baseball;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.service.BaseballGame;

public class Application {
    public static void main(String[] args) {
        new BaseballGame(new Computer(), new Player()).playGame();
    }
}
