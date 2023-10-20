package baseball;

import baseball.service.Game;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        Game game = new Game();
        do {
            game.play();
        } while (game.isReplay());
    }
}
