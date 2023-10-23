package baseball.service;

import baseball.domain.Baseballs;
import baseball.domain.Game;
import baseball.domain.GameResult;

public class GameService {

    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public Game createGame(BallGeneratorService ballGeneratorService) {
        return new Game(ballGeneratorService);
    }

    public GameResult compareAndResult(Baseballs computerBaseballs, Baseballs playerBaseballs) {
        int balls = computerBaseballs.countBalls(playerBaseballs);
        int strikes = computerBaseballs.countStrikes(playerBaseballs);
        return new GameResult(balls, strikes);
    }

    public String createGameResult(GameResult gameResult) {
        return gameResult.createGameResult();
    }

    public void updateGameState(Game game, GameResult gameResult) {
        if (gameResult.isThreeStrike()) {
            game.setGameOver();
        }
    }

    public boolean restartGame(String choice) {
        if (choice.equals(RESTART)) {
            return true;
        } if (choice.equals(EXIT)) {
            return false;
        }
        throw new IllegalArgumentException("1 또는 2 중 하나의 유효한 입력이 필요합니다.");
    }
}
