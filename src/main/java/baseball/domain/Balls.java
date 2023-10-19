package baseball.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Balls {
    public static final String INVALID_DIGIT_NUMBER_MESSAGE = "세 자리 숫자를 입력해주세요";
    public static final String SEPARATOR = "";
    public static final int BALLS_SIZE = 3;

    private final List<Ball> balls;

    public Balls(int treeDigitNumber) {
        validate(treeDigitNumber);
        balls = toBalls(treeDigitNumber);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    private List<Ball> toBalls(int treeDigitNumber) {
        ArrayList<Ball> balls = new ArrayList<>(BALLS_SIZE);
        for (String number : String.valueOf(treeDigitNumber).split(SEPARATOR)) {
            Ball ball = new Ball(Integer.parseInt(number));
            balls.add(ball);
        }
        return Collections.unmodifiableList(balls);
    }

    private void validate(int number) {
        if (String.valueOf(number).length() != BALLS_SIZE) {
            throw new IllegalArgumentException(INVALID_DIGIT_NUMBER_MESSAGE);
        }
    }
}
