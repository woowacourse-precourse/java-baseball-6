package baseball;

import baseball.config.AppConfig;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        appConfig.gameFactory().start();
    }
}