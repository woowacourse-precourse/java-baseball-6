package baseball;

import static baseball.io.ErrorHandler.checkRepeat;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        PlayBall playBall = new PlayBall();
        playBall.run();
    }
}
