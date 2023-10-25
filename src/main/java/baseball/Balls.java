package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Balls {
    public static final int BALLS_COUNT = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    public Balls(String str) {
        char[] chars = str.toCharArray();
        balls = new ArrayList<>();

        for (char ch : chars) {
            try {
                balls.add(new Ball(ch));
            } catch (NumberFormatException e) { throw new IllegalArgumentException("1~9 사이의 자연수만 입력이 가능합니다."); }
        }
    }

    public void validate(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);;

        if (ballSet.size() != BALLS_COUNT ) { throw new IllegalArgumentException("공의 숫자가 중복됩니다."); }
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

    public Ball getBallsByIndex(int index) {
        return this.balls.get(index);
    }

    public boolean contains(Ball ball) {
        return this.balls.contains(ball);
    }

    public boolean equals(Object obj) {
        Balls balls = (Balls)obj;

        return this.balls.equals(balls.balls);
    }

    public String toString() {
        return Arrays.toString(this.balls.toArray());
    }

    public int size() {
        return this.balls.size();
    }
}
