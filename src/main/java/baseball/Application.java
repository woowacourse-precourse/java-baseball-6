package baseball;

import baseball.computer.Computer;
import baseball.game.BaseBallGame;
import baseball.player.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame(new Player(), new Computer());
        baseBallGame.playGame();
    }
}
