package baseball;

import baseball.domain.Game;
import baseball.feature.GameOver;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Game game = new Game();
        GameOver gameOver = new GameOver();

        boolean end = true;

        while (end) {
            game.start();
            end = gameOver.isGameOver();
        }
    }
}
