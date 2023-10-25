package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    public static final String RESULT_NOTHING = "낫싱";

    private Balls balls = new Balls();
    private CompareResult compareResult = new CompareResult();

    public Balls createRandomBalls() {
        initBalls();

        while (!balls.isFull()) {
            Ball newBall = new Ball(Randoms.pickNumberInRange(1, 9));
            if (!balls.contains(newBall)) {
                balls.add(newBall);
            }
        }
        return balls;
    }

    private void initBalls() {
        balls = new Balls();
    }

    public void makeJudge(Balls playerBalls) {
        compareResult = balls.compare(playerBalls);

        if (compareResult.isNothing()) {
            System.out.println(RESULT_NOTHING);
            return;
        }
        if (compareResult.onlyBalls()) {
            System.out.printf("%d볼\n", compareResult.getBall());
            return;
        }
        if (compareResult.onlyStrikes()) {
            System.out.printf("%d스트라이크\n", compareResult.getStrike());
            return;
        }
        System.out.printf("%d볼 %d스트라이크\n", compareResult.getBall(), compareResult.getStrike());
    }

    public boolean gameFinished(Balls playerBalls) {
        compareResult = balls.compare(playerBalls);

        return compareResult.getStrike() == Balls.MAX_LENGTH;
    }
}
