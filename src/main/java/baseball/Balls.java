package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class Balls {
    public static final int BALLS_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    public static Balls makeRandomBalls() {
        List<Ball> balls = new ArrayList<>();

        while (balls.size() != BALLS_COUNT) {
            Ball ball = new Ball(Randoms.pickNumberInRange(1, 9));

            if (!balls.contains(ball)) {
                balls.add(ball);
            }
        }
        return new Balls(balls);
    }

    public static Balls stringToBalls(String str) {
        char[] chars = str.toCharArray();
        List<Ball> balls = new ArrayList<>();

        for (char ch : chars) {
            balls.add(new Ball(ch));
        }
        return new Balls(balls);
    }

    private void validate(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != BALLS_COUNT) {
            throw new IllegalArgumentException("숫자가 중복 됩니다.");
        }
    }

    public Ball get(int index) {
        return balls.get(index);
    }

    public boolean contains(Ball ball) {
        return this.balls.contains(ball);
    }

    @Override
    public boolean equals(Object obj) {
        Balls balls = (Balls)obj;
        return this.balls.equals(balls.balls);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.balls.toArray());
    }

    public int getSize() {
        return this.balls.size();
    }
}