package baseball;

import baseball.global.Config;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Config config = new Config();
            config.gameController().run();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }


    }
}
