package baseball;

import baseball.service.BaseBallGameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        boolean gameFlag = true;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while(gameFlag) {
            BaseBallGameService game = new BaseBallGameService();

            game.start();
            game.gameOver();
            gameFlag = game.restart();
        }
    }
}
