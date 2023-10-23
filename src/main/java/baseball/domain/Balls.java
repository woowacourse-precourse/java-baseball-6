package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        checkNumberLength(nums);
        checkNum(nums);
        checkDuplicates(nums);

        String[] numbers = nums.split("");

        for (String num : numbers) {
            int ball = Integer.parseInt(num);
            checkContainZero(ball);
            addBall(ball);
        }
    }

    private void checkDuplicates(String nums) {
        Set<Character> deDuplication = new HashSet<>();
        for (Character num : nums.toCharArray()) {
            if (!deDuplication.add(num)) {
                throw new IllegalArgumentException("서로 다른 정수를 입력해야 합니다.");
            }
        }
    }

    private void checkContainZero(int ball) {
        if (ball == 0) {
            throw new IllegalArgumentException("1과 9사이의 정수만 입력하세요.");
        }
    }

    private void checkNum(String nums) {
        if (!nums.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자는 정수이어야 합니다.");
        }
    }

    private void checkNumberLength(String numbers) {
        if (numbers.length() != 3) {
            throw new IllegalArgumentException("숫자의 개수는 3개이어야 합니다.");
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
