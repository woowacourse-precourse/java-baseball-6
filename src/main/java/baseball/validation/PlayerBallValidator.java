package baseball.validation;

import static baseball.model.BaseballGame.MAX_BALL;
import static baseball.model.BaseballGame.MAX_BALL_SIZE;
import static baseball.model.BaseballGame.MIN_BALL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import baseball.exception.ExceptionMessage;

public class PlayerBallValidator {
    private final List<String> checkResultList = new ArrayList<>();

    public List<String> validate(final String target) {
        isLengthMaxBallSize(target);
        isDuplicate(target);
        isDigit(target);
        isBetweenValidBall(target);
        return checkResultList;
    }

    private void isLengthMaxBallSize(final String target) {
        if (target.length() != MAX_BALL_SIZE) {
            checkResultList.add(ExceptionMessage.INVALID_LENGTH.format(MAX_BALL_SIZE));
        }
    }

    private void isDuplicate(final String target) {
        HashSet<Character> characterHashSet = new HashSet<>();
        for (char c : target.toCharArray()) {
            characterHashSet.add(c);
        }
        int ballSize = characterHashSet.size();
        if (ballSize != MAX_BALL_SIZE) {
            checkResultList.add(ExceptionMessage.NOT_MUST_BE_DUPLICATE.format(target));
        }
    }

    private void isDigit(final String target) {
        for (char c : target.toCharArray()) {
            if (!Character.isDigit(c)) {
                checkResultList.add(ExceptionMessage.MUST_BE_DIGIT.format());
                return;
            }
        }
    }

    private void isBetweenValidBall(final String target) {
        for (char c : target.toCharArray()) {
            int ball = Character.getNumericValue(c);
            if ((ball < MIN_BALL) || (ball > MAX_BALL)) {
                checkResultList.add(ExceptionMessage.MUST_BE_BETWEEN.format(MIN_BALL, MAX_BALL));
                return;
            }
        }
    }
}
