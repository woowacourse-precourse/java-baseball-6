package baseball;

import baseball.config.AppConfig;
import baseball.domain.BaseballGame;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = BaseballGame.from(AppConfig.getMessagePrinter());
        baseballGame.start();
    }
}
