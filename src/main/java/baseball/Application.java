package baseball;

import baseball.config.AppConfig;
import baseball.domain.BaseballGame;

public class Application {

    public static void main(String[] args) {
        BaseballGame baseballGame = BaseballGame.of(AppConfig.getMessagePrinter(), AppConfig.getInputHandler());
        baseballGame.start();
    }
}
