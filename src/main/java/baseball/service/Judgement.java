package baseball.service;

import baseball.service.domain.BaseballCollection;

public class Judgement {
    // 기능: 힌트 얻기
    public GameResult calculateHint(BaseballCollection computerBalls, BaseballCollection playerBalls) {
        int strikeCount = computerBalls.calculateStrikeCount(playerBalls);
        int ballCount = computerBalls.calculateBallCount(playerBalls);
        return new GameResult(ballCount, strikeCount);
    }
}