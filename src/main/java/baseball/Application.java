package baseball;

import baseball.games.numberbaseball.core.BaseballExecutor;
import baseball.games.numberbaseball.util.BaseballPrinter;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameRunner gameRunner = new GameRunner(new BaseballExecutor(), new BaseballPrinter());
        gameRunner.run();
    }
}
