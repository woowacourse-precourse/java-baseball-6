package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Computer {
    Ball ball;

    public Computer() {

    }

    public Ball drawBall() {
        List<Integer> pickNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        return ball = new Ball(pickNumbers);
    }

    public MatchResult matchBall(Ball userBall) {
        int matchNumberCount = getTotalMatchNumberCount(userBall);
        int strikeCount = getStrikeCount(userBall);
        int ballCount = matchNumberCount - strikeCount;

        return new MatchResult(ballCount, strikeCount);
    }

    private int getStrikeCount(Ball userBall) {
        int strikeCount = 0;
        int computerBallValue = ball.value;
        int userBallValue = userBall.value;

        while (computerBallValue > 0 && userBallValue > 0) {
            if (computerBallValue % 10 == userBallValue % 10) {
                strikeCount++;
            }
            computerBallValue /= 10;
            userBallValue /= 10;
        }
        return strikeCount;
    }

    private int getTotalMatchNumberCount(Ball userBall) {
        int totalMatched = 0;
        int userBallValue = userBall.value;

        while (userBallValue > 0) {
            totalMatched += ball.getMatchCount(userBallValue % 10);
            userBallValue /= 10;
        }
        return totalMatched;
    }
}
