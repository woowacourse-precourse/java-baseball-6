package baseball;

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
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputRestart = Console.readLine();
        if (inputRestart.equals("1")) {
            return true;
        } else if (inputRestart.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }
}