package baseball;

import baseball.game.Game;

/**
 * 숫자 야구 게임이다.
 *
 * @author Seongha Park
 */
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        do {
            game.startGame();
        } while (game.checkRestart());
        game.endGame();
    }
}
