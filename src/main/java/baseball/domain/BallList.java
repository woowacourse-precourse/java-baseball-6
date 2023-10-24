package baseball.domain;

import baseball.utils.Converter;
import baseball.utils.Validator;
import java.util.List;

public class BallList {

    private final List<Ball> myBallList;
    private static final int MAX_LENGTH = 3;

    public BallList(List<Ball> myBallList) {
        String input = Converter.convertBallListToString(myBallList);
        validate(input);
        this.myBallList = myBallList;
    }

    public BallList(String input) {
        validate(input);
        this.myBallList = Converter.extractDigitsFromNumber(Integer.parseInt(input));
    }

    public int calculateBall(BallList userNumber) {
        int ballCount = 0;
        for (int i = 0; i < MAX_LENGTH; i++) {
            Ball userDigit = userNumber.getDigit(i);
            for (int j = 0; j < MAX_LENGTH; j++) {
                Ball computerDigit = myBallList.get(j);
                if (userDigit.isOnlySameValue(computerDigit)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    public int calculateStrike(BallList userNumber) {
        int strikeCount = 0;
        for (int i = 0; i < MAX_LENGTH; i++) {
            Ball userDigit = userNumber.getDigit(i);
            for (int j = 0; j < MAX_LENGTH; j++) {
                Ball computerDigit = myBallList.get(j);
                if (userDigit.isSame(computerDigit)) {
                    strikeCount++;
                }
            }
        }
        return strikeCount;
    }

    private void validate(String input) {
        Validator.validateNotEmpty(input);
        Validator.validateIsNumeric(input);
        Validator.validateLength(input);
        Validator.validateDigitsInRange(input);
        Validator.validateDigitsAreDistinct(input);
    }

    public Ball getDigit(int index) {
        return myBallList.get(index);
    }


}