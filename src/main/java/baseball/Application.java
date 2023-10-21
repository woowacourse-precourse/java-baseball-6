package baseball;

import baseball.controller.PlayBaseballGame;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        PlayBaseballGame game = new PlayBaseballGame();
        game.play();
    }
}
