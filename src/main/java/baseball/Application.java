package baseball;

import baseball.domain.BaseBall;
import baseball.domain.Calculator;
import baseball.domain.Game;
import baseball.utils.GameManager;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new BaseBall(new Calculator());
        GameManager gameManager = new GameManager(game);

        gameManager.game();
    }
}
