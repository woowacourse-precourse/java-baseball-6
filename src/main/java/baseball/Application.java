package baseball;

import baseball.config.AppConfig;
import baseball.domain.BaseballGame;

public class Application {

    public static void main(String[] args) {
        BaseballGame baseballGame = BaseballGame.newBuilder()
                .messagePrinter(AppConfig.getMessagePrinter())
                .inputHandler(AppConfig.getInputHandler())
                .pitcher(AppConfig.getPitcher())
                .batter(AppConfig.getBatter())
                .build();

        baseballGame.start();
    }
}
