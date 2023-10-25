package baseball;

import static baseball.global.common.GameMessage.GAME_START_MESSAGE;

import baseball.domain.BaseballHandler;
import baseball.domain.Computer;
import baseball.domain.GameHandler;

public class Application {
    public static void main(String[] args) {
        boolean restartGameFlag;
        System.out.print(GAME_START_MESSAGE.message);
        do {
            Computer computer = new Computer();
            computer.pickRandomNumbers();
            BaseballHandler baseballHandler = new BaseballHandler(computer);
            baseballHandler.execute();
            GameHandler gameHandler = new GameHandler();
            restartGameFlag = gameHandler.isRestart();
        } while (restartGameFlag);
    }
}
