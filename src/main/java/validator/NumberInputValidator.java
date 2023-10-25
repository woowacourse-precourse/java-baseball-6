package validator;

import java.util.HashSet;
import java.util.Set;

public class NumberInputValidator {
    void vaildNumberOverThreeDigits(String balls) {
        if (balls.length() > 3) {
            throw new IllegalArgumentException("공의 개수가 3개 보다 많아요.");
        }
    }

    void vaildNumberUnderThreeDigits(String balls) {
        if (balls.length() < 3) {
            throw new IllegalArgumentException("공의 개수가 3개 보다 적어요.");
        }
    }

    void vaildNumberRange(String balls) {
        for (char ball: balls.toCharArray()) {
            if (ball < '0' && ball > '9') {
                throw new IllegalArgumentException("숫자가 아니거나, 범위를 넘었어요.");
            }
        }
    }

    void validContainSameNumber(String balls) {
        if (isContainSameNumber(balls)) {
            throw new IllegalArgumentException("같은 숫자가 포함되었어요.");
        }
    }

    boolean isContainSameNumber(String balls) {
        Set<Character> detailNumber =  new HashSet<>();
        for (char ball: balls.toCharArray()) {
            if (detailNumber.contains(ball)) {
                return true;
            }
            detailNumber.add(ball);
        }
        return false;
    }
}
