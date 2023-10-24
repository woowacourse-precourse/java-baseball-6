package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import baseball.constant.Constant;
import baseball.constant.errorMessage.InputError;

/**
 * 역할 : 사용자가 입력한 서로 다른 임의의 수 3개 관리
 */
public class PlayerBalls {

    private List<Ball> balls;


    public PlayerBalls(Integer[] input) {
        this.balls = createBalls(input);
    }

    private List<Ball> createBalls(Integer[] input) {
        List<Ball> balls = convertIntArrToBallList(input);
        validateLength(balls);
        validateDuplicate(balls);
        return balls;
    }

    private List<Ball> convertIntArrToBallList(Integer[] input) {
        return Arrays.stream(input)
                .map(num -> new Ball(num))
                .collect(Collectors.toList());
    }


    private static void validateDuplicate(List<Ball> balls) {
        if (balls.stream()
                .collect(Collectors.toSet())
                .size() != Constant.BALLS_LENGTH)
            throw new IllegalArgumentException(InputError.WRONG_NUMBER_DUPLICATE);
    }


    private static void validateLength(List<Ball> balls) {
        if (Constant.BALLS_LENGTH != balls.size())
            throw new IllegalArgumentException(InputError.WRONG_NUMBER_COUNT);
    }


    public List<Ball> getBalls() {
        return Collections.unmodifiableList(this.balls);
    }

}
