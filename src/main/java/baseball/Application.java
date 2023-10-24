package baseball;

import baseball.game.BaseballGameProcess;
import baseball.game.BaseBallGame;
import baseball.game.Game;
import baseball.game.GameProcess;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game baseBallGame = new BaseBallGame();
        GameProcess baseBallGameProcess = new BaseballGameProcess();
        baseBallGame.execute(baseBallGameProcess);
    }
}
