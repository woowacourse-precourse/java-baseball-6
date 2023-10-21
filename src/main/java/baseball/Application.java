package baseball;

import baseball.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        GameLauncher gameLauncher = new GameLauncher(new RandomNumberGenerator());
        gameLauncher.launch();
    }
}
