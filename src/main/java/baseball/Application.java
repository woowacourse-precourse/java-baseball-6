package baseball;

import baseball.service.BaseBallGameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameFlag = true;

        while(gameFlag) {
            BaseBallGameService game = new BaseBallGameService();

            game.start();
            game.gameOver();
            gameFlag = game.restart();
        }
    }
}
