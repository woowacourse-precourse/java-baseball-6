package baseball;

import baseball.controller.BaseballGame;
import baseball.model.Computer;
import baseball.model.Player;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();

        BaseballGame baseballGame = new BaseballGame(computer, player);
        baseballGame.start();
    }
}
