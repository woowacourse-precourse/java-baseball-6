package baseball;

import baseball.domain.interfaces.baseball.Game;
import baseball.domain.baseball.BaseballGame;

public class Application {
    public static void main(String[] args) throws IllegalStateException {
        // TODO: 인터페이스로 수정
        Game game = new BaseballGame();
        game.start();
    }
}
