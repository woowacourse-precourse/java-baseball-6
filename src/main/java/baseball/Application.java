package baseball;

import baseball.game.NumberBaseBallGame;

public class Application {
    private static boolean isFirst = true;
    private static Long computerId = 1L;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        NumberBaseBallGame game = new NumberBaseBallGame();
        game.run();
    }
}
