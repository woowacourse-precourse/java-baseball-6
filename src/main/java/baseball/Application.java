package baseball;

import baseball.gameLogic.NumberBaseBall;

public class Application {
    public static void main(String[] args) {
        NumberBaseBall baseBallRunner = new NumberBaseBall();
        baseBallRunner.init();
        baseBallRunner.run();
    }
}
