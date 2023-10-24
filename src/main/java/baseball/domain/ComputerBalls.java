package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
import java.util.stream.Collectors;

import baseball.constant.Constant;


/**
 * 역할 : 서로 다른 임의의 3개의 수 생성 및 관리
 */
public class ComputerBalls {

    private final List<Ball> balls;

    public ComputerBalls() {
        this.balls = createBalls();
    }

    private List<Ball> createBalls() {
        List<Integer> numbers = generateNotDuplicateRandomNumbers();
        return convertIntListToBallList(numbers);
    }

    private List<Integer> generateNotDuplicateRandomNumbers() {
        List<Integer> numbers = generateRandomNumbers();
        while (checkDuplicateNumber(numbers)) {
            numbers = generateRandomNumbers();
        }
        return numbers;
    }

    private List<Integer> generateRandomNumbers() {
        return Arrays.stream(new List[Constant.BALLS_LENGTH])
                .map(num -> Randoms.pickNumberInRange(Constant.START_RANGE, Constant.END_RANGE))
                .collect(Collectors.toList());
    }
    private Boolean checkDuplicateNumber(List<Integer> numbers) {
        if (numbers.stream()
                .collect(Collectors.toSet())
                .size() != Constant.BALLS_LENGTH)
            return true;

        return false;
    }

    private List<Ball> convertIntListToBallList(List<Integer> numbers) {
        return numbers.stream()
                .map(num -> new Ball(num))
                .collect(Collectors.toList());
    }


    public List<Ball> getBalls() {
        return Collections.unmodifiableList(this.balls);
    }
}
