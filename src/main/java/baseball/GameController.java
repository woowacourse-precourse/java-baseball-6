package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private final int GAME_SIZE = 3;
    private final int START_INCLUSIVE = 1;
    private final int END_INCLUSIVE = 9;
    private static final String RESTART = "1";
    private static final String GAME_OVER = "2";
    private static final String START_OF_GAME = "숫자 야구 게임을 시작합니다.";

    private static final String RESTART_OF_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Game game = new Game(GAME_SIZE);

    public void start() {
        System.out.println(START_OF_GAME);
        do {
            game.init(START_INCLUSIVE, END_INCLUSIVE);
            game.run();
        } while (restart());
    }

    private boolean restart() {
        System.out.println(RESTART_OF_GAME);
        String s = Console.readLine();
        if (!s.equals(RESTART) && !s.equals(GAME_OVER)) {
            throw new IllegalArgumentException("BAD INPUT");
        }
        return s.equals(RESTART);
    }

}
