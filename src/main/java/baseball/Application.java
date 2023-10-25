package baseball;

import baseball.computer.Computer;
import baseball.game.BaseballGame;
import baseball.player.Player;
import baseball.utils.generator.BaseballRandomNumbersGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGame game = new BaseballGame(new Computer(getNumberGenerator()), new Player());
        game.start();
    }

    private static BaseballRandomNumbersGenerator getNumberGenerator() {
        return new BaseballRandomNumbersGenerator();
    }
}
