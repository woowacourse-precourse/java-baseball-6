package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls = new ArrayList<>();

    public Balls() {
        createRandomNumbers();
    }

    public Balls(Ball firstBall, Ball secondBall, Ball thirdBall) {
        isDuplication(firstBall, secondBall, thirdBall);
        balls.add(firstBall);
        balls.add(secondBall);
        balls.add(thirdBall);
    }

    private void isDuplication(Ball firstBall, Ball secondBall, Ball thirdBall) {
        if (firstBall.equals(secondBall)
                || firstBall.equals(thirdBall)
                || secondBall.equals(thirdBall)) {
            throw new IllegalArgumentException("중복된 값이 있습니다.");
        }
    }

    private void createRandomNumbers() {
        balls = new ArrayList<>();

        while (balls.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            Ball randomBall = new Ball(randomNumber);
            if (indexOf(randomBall) == -1) {
                balls.add(randomBall);
            }
        }
    }

    public boolean match(Balls targetBalls) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < balls.size(); i++) {
            int searchIndex = targetBalls.indexOf(balls.get(i));
            if (searchIndex == i) {
                strikeCount++;
            } else if (searchIndex >= 0) {
                ballCount++;
            }
        }

        GameIO.gameResultPrint(strikeCount, ballCount);
        return strikeCount == 3;
    }

    private int indexOf(Ball targetBall) {
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);
            if (ball.equals(targetBall)) {
                return i;
            }
        }
        return -1;
    }
}
