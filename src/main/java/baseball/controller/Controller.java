package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Player;

public class Controller {
    private boolean isGameInProgress;

    public Controller() {
        isGameInProgress = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void play() {
        while (isGameInProgress) {
            Computer computer = new Computer();
            Player player = new Player();
            Game game = new Game();
        }

    }
}
