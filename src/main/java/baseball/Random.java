package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Random {
    public static final int BALLS_COUNT = 3;

    private final List<Validate> validates;

    public Random(List<Validate> validates) {
        validateBall(validates);
        this.validates = validates;
    }

    public static Random makeRandomBalls() {
        List<Validate> balls = new ArrayList<>();

        while (balls.size() != BALLS_COUNT) {
            Validate validate = new Validate(Randoms.pickNumberInRange(1, 9));

            if (!balls.contains(validate)) {
                balls.add(validate);
            }
        }
        return new Random(balls);
    }

    public static Random stringToBalls(String str) {
        char[] chars = str.toCharArray();
        List<Validate> balls = new ArrayList<>();

        for (char ch : chars) {
            balls.add(new Validate(ch));
        }
        return new Random(balls);
    }

    private void validateBall(List<Validate> balls) {
        Set<Validate> ballSet = new HashSet<>(balls);

        if (ballSet.size() != BALLS_COUNT) {
            throw new IllegalArgumentException("공의 숫자가 중복 됩니다.");
        }
    }

    public Validate get(int index) {
        return validates.get(index);
    }

    public boolean contains(Validate ball) {
        return this.validates.contains(ball);
    }

    @Override
    public boolean equals(Object obj) {
        Random balls = (Random) obj;
        return this.validates.equals(balls.validates);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.validates.toArray());
    }

    public int getSize() {
        return this.validates.size();
    }
}
