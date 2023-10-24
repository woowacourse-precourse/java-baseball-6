package baseball;

import baseball.domain.BaseBallGame;
import baseball.domain.computer.Computer;
import baseball.domain.player.Player;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computerAnswerByRandomGenerator = Computer.init();
        Player playerByIntegerNumbers = Player.createPlayerByIntegerNumbers(List.of(1, 2, 3));
        BaseBallGame baseballGame = new BaseBallGame(computerAnswerByRandomGenerator, playerByIntegerNumbers);
        baseballGame.startGame();
    }
}
