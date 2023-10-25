package baseball.service;

import baseball.service.domain.BaseballCollection;

public class Referee {
    public GameResult calculateHint(BaseballCollection computerBalls, BaseballCollection playerBalls) {
        int strikeCount = computerBalls.calculateStrikeCount(playerBalls);
        int ballCount = computerBalls.calculateBallCount(playerBalls);
        return new GameResult(ballCount, strikeCount);
    }
}