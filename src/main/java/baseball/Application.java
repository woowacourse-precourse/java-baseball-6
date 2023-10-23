package baseball;

import baseball.domain.NumberBaseballGame;

public class Application {
    public static void main(String[] args) throws IllegalStateException {
        // TODO: 인터페이스로 수정
        NumberBaseballGame game = NumberBaseballGame.getInstance();
        game.start();
    }
}
