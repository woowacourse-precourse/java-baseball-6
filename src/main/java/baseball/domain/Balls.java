package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Integer> balls = new ArrayList<>();

    public void addBall(int ball) {
        balls.add(ball);
    }

    public boolean isSizeSame(int num) {
        return balls.size() == num;
    }

    public boolean isContain(int newBall) {

        for (int ball : balls) {
            if (ball == newBall) {
                return true;
            }
        }
        return false;
    }

    public void convertToBalls(String nums) {
        String[] numArr = nums.split("");

        for (String num : numArr) {
            addBall(Integer.parseInt(num));
        }
    }

    public int get(int i) {
        return balls.get(i);
    }

    public boolean isSameWithIndexValue(int index, int ball) {
        return isSame(get(index), ball);
    }

    private boolean isSame(int ball1, int ball2) {
        return ball1 == ball2;
    }
}
