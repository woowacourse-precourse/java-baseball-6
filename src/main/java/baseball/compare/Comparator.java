package baseball.compare;

import baseball.balls.Balls;

public class Comparator {

    public String compareBalls(Balls answerBalls, Balls playerBalls) {
        int strikeCount = new StrikeCounter().strikeCount(answerBalls, playerBalls);
        int ballCount = new BallCounter().ballCount(answerBalls,playerBalls);

        return new CompareResultStringCreator().compareResultStringCreate(strikeCount, ballCount);
    }
}
