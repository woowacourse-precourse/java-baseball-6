package baseball;

import baseball.service.BaseBallGame;

public class Application {
    public static void main(String[] args) {
        // 숫자 야구 게임 시작
        BaseBallGame game = new BaseBallGame();
        game.startGame();
    }
}
