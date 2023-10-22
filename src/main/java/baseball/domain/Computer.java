package baseball.domain;

import baseball.util.RandomNum;

public class Computer {

    private static final int MAX_NUM = 3;

    private final Balls balls = new Balls();
    private final RandomNum randomNum = new RandomNum();

    public void createRandomBalls() {
        while (balls.isSizeSame(MAX_NUM)) {
            int newBall = randomNum.create();

            if (!balls.isContain(newBall)) {
                balls.addBall(newBall);
            }
        }
    }
}
