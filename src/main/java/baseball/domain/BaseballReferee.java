package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballReferee {
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼 ";
    public static final int ZERO = 0;

    public String referee(List<Integer> randomNumber, List<Integer> inputNumber) {
        int ballCount = ballCount(randomNumber, inputNumber);
        int strikeCount = strikeCount(randomNumber, inputNumber);

        if (strikeCount == ZERO && ballCount == ZERO) {
            return NOTHING;
        }

        if (ballCount - strikeCount == ZERO) {
            return strikeCount + STRIKE;
        }

        if (strikeCount == ZERO) {
            return ballCount + BALL;
        }

        return ballCount - strikeCount + BALL + strikeCount + STRIKE;
    }

    private int ballCount(List<Integer> randomNumber, List<Integer> inputNumber) {
        int ballCount = randomNumber.size() + inputNumber.size();
        Set<Integer> addNumber = new HashSet<>();
        addNumber.addAll(randomNumber);
        addNumber.addAll(inputNumber);
        ballCount = ballCount - addNumber.size();

        return ballCount;
    }

    private int strikeCount(List<Integer> randomNumber, List<Integer> inputNumber) {
        int strikeCount = ZERO;
        for (int i = ZERO; i < randomNumber.size(); i++) {
            if (randomNumber.get(i).equals(inputNumber.get(i))) {
                strikeCount++;
            }
        }

        return strikeCount;
    }

}
