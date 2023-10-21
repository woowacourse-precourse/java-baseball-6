package baseball;

import baseball.config.AppConfig;
import baseball.game.GameLauncher;

public class Application {

    private static final AppConfig appConfig = new AppConfig();
    private static final GameLauncher gameLauncher = appConfig.gameLauncher();

    public static void main(String[] args) {
        gameLauncher.playGame();
    }
}