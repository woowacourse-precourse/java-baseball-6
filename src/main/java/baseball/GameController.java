package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final int GAME_SIZE = 3;
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private static final String RESTART = "1";
    private static final String GAME_OVER = "2";


    private Game game = new Game(GAME_SIZE);

    public void start() {
        Message.start();
        do {
            game.init(START_INCLUSIVE, END_INCLUSIVE);
            game.play();
        } while (restart());
    }

    private boolean restart() {
        Message.restart();
        String s = Console.readLine();
        if (!s.equals(RESTART) && !s.equals(GAME_OVER)) {
            throw new IllegalArgumentException("BAD INPUT");
        }
        return s.equals(RESTART);
    }

}
