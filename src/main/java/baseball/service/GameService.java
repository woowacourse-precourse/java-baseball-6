package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameResult;

public class GameService {
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public Game createGame(BallGeneratorService ballGeneratorService) {
        return new Game(ballGeneratorService);
    }

    public GameResult compareAndResult(Balls computerBalls, Balls playerBalls) {
        int balls = computerBalls.countBalls(playerBalls);
        int strikes = computerBalls.countStrikes(playerBalls);
        return new GameResult(balls, strikes);
    }

    public String createGameResult(GameResult gameResult) {
        return gameResult.createGameResult();
    }

    public void updateGameState(Game game, GameResult gameResult) {
        if (gameResult.isThreeStrike()) {
            game.toggleGameOver();
        }
    }

    public boolean restartGame(String choice) {
        if (choice.equals(RESTART)) {
            return true;
        } else if (choice.equals(EXIT)) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2 중 하나의 유효한 입력이 필요합니다.");
    }
}
