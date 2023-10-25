package baseball;

import baseball.service.Game;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        Game game;
        do {
            game = new Game();
            game.start();
            game.clear();
        } while (game.restart());
    }
}
