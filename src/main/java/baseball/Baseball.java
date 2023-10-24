package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Baseball {

    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final String INVALID_NUMBER = "0";
    List<Integer> balls;

    public Baseball() {
        balls = new ArrayList<>();

        while (balls.size() < BASEBALL_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!balls.contains(randomNumber)) {
                balls.add(randomNumber);
            }
        }
    }

    public Baseball(String input) {
        validate(input);
        balls = inputToBalls(input);
    }

    private void validate(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        if (input.contains(INVALID_NUMBER)) {
            throw new IllegalArgumentException(INVALID_NUMBER + "은 입력할 수 없습니다.");
        }
        if (input.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_LENGTH + "자리 수를 입력해야 합니다.");
        }
        if (isDuplicated(input)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    private List<Integer> inputToBalls(String input) {
        List<Integer> balls = new ArrayList<>();
        int temp = 0;

        try {
            temp = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        while (temp > 0) {
            balls.add(0, temp % 10);
            temp /= 10;
        }

        return balls;
    }

    public Boolean isDuplicated(String number) {
        return number.length() != number.chars().distinct().count();
    }

    public Score checkResult(Baseball compare) {
        int strikeCount = computeStrike(compare.balls);
        int ballCount = computeBall(compare.balls);
        boolean isComplete = (strikeCount == BASEBALL_NUMBER_LENGTH);

        return new Score(strikeCount, ballCount, isComplete);
    }

    private int computeStrike(List<Integer> compareBalls) {
        int count = 0;

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            if (Objects.equals(this.balls.get(i), compareBalls.get(i))) {
                count++;
            }
        }

        return count;
    }

    private int computeBall(List<Integer> compareBalls) {
        int count = 0;

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            if (this.balls.contains(compareBalls.get(i))
                    && !Objects.equals(this.balls.get(i), compareBalls.get(i))) {
                count++;
            }
        }

        return count;
    }

    public String toString() {
        return balls.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
