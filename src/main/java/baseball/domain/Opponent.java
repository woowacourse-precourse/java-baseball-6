package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Opponent {
    private final String number;
    private final int DIGIT = 3;

    public Opponent() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3) {
            numberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        this.number = numberSet.stream().map(Object::toString).collect(Collectors.joining());
    }

    public BallCount analyzeTry(String userInput) {
        return new BallCount(countBall(userInput), countStrike(userInput));
    }

    private int countStrike(String userInput) {
        int strike = 0;
        for (int i = 0; i < DIGIT; i++) {
            if (this.number.charAt(i) == userInput.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    private int countBall(String userInput) {
        int ball = 0;
        for (int i = 0; i < DIGIT; i++) {
            if (userInput.contains(String.valueOf(this.number.charAt(i)))
                    && this.number.charAt(i) != userInput.charAt(i)) {
                ball++;
            }
        }
        return ball;
    }
}
