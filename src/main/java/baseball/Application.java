package baseball;

import baseball.game.Game;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        try {
            game.play();
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException();
        }

    }
}
