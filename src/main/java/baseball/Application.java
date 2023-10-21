package baseball;

import baseball.domain.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Config config = new Config();
        NumberBaseball numberBaseball = config.numberBaseball(3);
        numberBaseball.startGame();
    }
}
