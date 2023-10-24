package baseball;

import baseball.en.GameStatus;
import baseball.service.BaseballGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        final int NUMBER_SIZE = 3;


        BaseballGame game = new BaseballGame();
        game.startGame(NUMBER_SIZE);

        while (game.getStatus() == GameStatus.RUN) {

        }
    }
}
