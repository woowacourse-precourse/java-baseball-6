package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Baseball {

    public static final int BASEBALL_NUMBER_LENGTH = 3;
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
        balls = new ArrayList<>();
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

        if (balls.size() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(BASEBALL_NUMBER_LENGTH + "자리 수를 입력해야 합니다.");
        }
        if (balls.contains(0)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
        if (isDuplicated(balls)) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public Boolean isDuplicated(List<Integer> number) {
        for (int i = 0; i < number.size(); i++) {
            int duplication = Collections.frequency(number, number.get(i));
            if (duplication > 1) {
                return true;
            }
        }
        return false;
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
}
