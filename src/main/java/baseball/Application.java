package baseball;

import java.io.IOException;


public class Application {
    public static void main(String[] args) throws IOException {

        BaseballGame baseballGame = new BaseballGame();

        int repeat = 0;

        while(repeat != 2) {
            repeat = baseballGame.startGame();
        }

    }
}
