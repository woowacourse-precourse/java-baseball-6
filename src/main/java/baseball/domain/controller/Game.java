package baseball.domain.controller;

import baseball.domain.model.BallGenerator;

import java.util.List;

public class Game {
    public static final String INIT_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String RESTART_SIGNAL = "1";
    public static final String EXIT_SIGNAL = "2";

    private Game() {
    }

    private static class GameHolder {
        private static final Game INSTANCE = new Game();
    }

    public static Game getInstance() {
        return GameHolder.INSTANCE;
    }

    public void start() {
        System.out.println(INIT_GAME_START_MESSAGE);

        BallGenerator ballGenerator = BallGenerator.getInstance();

        boolean isProgress = true;
        while (isProgress) {
            List<String> computerBalls = ballGenerator.makeComputerBalls();
            GameController gameController = new GameController(computerBalls);

            playBaseball(gameController);
        }
    }

    private void playBaseball(GameController gameController) {
    }

}
