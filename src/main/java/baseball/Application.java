package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean isAgain = true;
        Game game = new Game();

        while (isAgain) {
            game.setRandomNumber();
            while (game.strike != 3) {
                game.playGame();
            }
            game.checkGameStatus();
            if (game.gameStatus == 1) {
                game.strike = 0;
                game.ball = 0;
                game.gameStatus = 0;
            }
            if (game.gameStatus == 2) {
                isAgain = false;
            }
        }
    }
}
