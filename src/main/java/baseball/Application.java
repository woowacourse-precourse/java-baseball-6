package baseball;

import static baseball.constant.BaseballConstant.GAME_EXIT;
import static baseball.constant.BaseballConstant.GAME_RESTART;
import static baseball.constant.BaseballConstant.GAME_RESTART_ASK_MESSAGE;

import baseball.domain.Game;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private final Game game;

    Application(Game game) {
        this.game = game;
    }

    public static void main(String[] args) {
        Game game = new Game();
        Application application = new Application(game);
        application.loop();
    }

    void loop() {
        this.game.printStartMessage();
        do {
            this.game.initGame();
            this.game.start();
        } while (readRestartIntent());
    }

    private boolean readRestartIntent() throws IllegalArgumentException {
        System.out.println(GAME_RESTART_ASK_MESSAGE);
        String inputRestart = Console.readLine();
        if (inputRestart.equals(GAME_RESTART)) {
            return true;
        } else if (inputRestart.equals(GAME_EXIT)) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}