package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallList {
    public static final int BALL_COUNT = 3;

    private final List<Ball> ballList;

    public BallList(List<Ball> ballList) {
        validate(ballList);
        this.ballList = ballList;
    }

    // ballList 중복 검사
    private void validate(List<Ball> ballList) {
        Set<Ball> ballSet = new HashSet<>(ballList);
        if (ballSet.size() != BALL_COUNT) {
            throw new IllegalArgumentException("공의 숫자가 중복됩니다.");
        }
    }

    // 중복되지 않도록 ballList 랜덤 생성
    public static BallList makeRandomBallList() {
        List<Ball> ballList = new ArrayList<>();

        while (ballList.size() != BALL_COUNT) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1, 9));

            if (!ballList.contains(ball)) {
                ballList.add(ball);
            }
        }
        return new BallList(ballList);
    }

    public Ball get(int index) {
        return ballList.get(index);
    }

    public boolean contains(Ball ball) {
        return this.ballList.contains(ball);
    }

    public static BallList stringToBallList(String str) {
        char[] chars = str.toCharArray();
        List<Ball> ballList = new ArrayList<>();

        for (char ch : chars) {
            ballList.add(new Ball(ch));
        }
        return new BallList(ballList);
    }

    @Override
    public boolean equals(Object obj) {
        BallList ballList = (BallList) obj;
        return this.ballList.equals(ballList.ballList);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.ballList.toArray());
    }

}
