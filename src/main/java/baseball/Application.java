package baseball;

import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        // 숫자 야구 게임 시작
        GameController controller = new GameController();
        controller.startGame();
    }
}
