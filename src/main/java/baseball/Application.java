package baseball;

import baseball.console.BaseBallGame;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.playGame();
    }
}
