package baseball;

import baseball.domain.BaseballHandler;
import baseball.domain.Computer;
import baseball.domain.GameHandler;

public class Application {
    public static void main(String[] args) {
        boolean restartGameFlag;
        do {
            Computer computer = new Computer();
            BaseballHandler baseballHandler = new BaseballHandler(computer);
            baseballHandler.execute();
            GameHandler gameHandler = new GameHandler();
            restartGameFlag = gameHandler.isRestart();
        } while (restartGameFlag);
    }
}
