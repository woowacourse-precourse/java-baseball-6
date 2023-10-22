package baseball.service;

import baseball.domain.Balls;
import baseball.domain.Game;
import baseball.domain.GameResult;

import static baseball.domain.Ball.BALL_SIZE;

public class GameLogicService {
    public GameResult compareBalls(Game game, Balls playerBalls) {
        Balls computerBalls = game.getComputerBalls();
        int balls = countBalls(computerBalls, playerBalls);
        int strikes = countStrikes(computerBalls, playerBalls);

        return new GameResult(balls, strikes);
    }

    private int countStrikes(Balls computerBalls, Balls playerBalls) {
        int strikes = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isStrike(index, computerBalls, playerBalls)) {
                strikes++;
            }
        }
        return strikes;
    }

    public void updateGameState(Game game, GameResult gameResult) {
        game.updateGameState(gameResult);
    }

    private boolean isStrike(int index, Balls computerBalls, Balls playerBalls) {
        return computerBalls.getBall(index).number().equals(playerBalls.getBall(index).number());
    }

    private int countBalls(Balls computerBalls, Balls playerBalls) {
        int balls = 0;
        for (int index = 0; index < BALL_SIZE; index++) {
            if (isBall(index, computerBalls, playerBalls)) {
                balls++;
            }
        }
        return balls;
    }

    private boolean isBall(int index, Balls computerBalls, Balls playerBalls) {
        return !isStrike(index, computerBalls, playerBalls) && computerBalls.containsOtherBall(playerBalls.getBall(index));
    }

}
