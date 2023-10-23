package baseball;

import baseball.gamebaseball.baseballgame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        baseballgame baseballgame = appConfig.baseballgame();
        baseballgame.play();

    }
}
