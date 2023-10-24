package baseball.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

public class BallNumber {
    public ArrayList<Integer> ballNumberList;

    public BallNumber(String newBallNumber) {
        ballNumberList = (ArrayList<Integer>) newBallNumber
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(toList());
    }

    public BallNumber(List<Integer> newBallNumber) {
        ballNumberList = (ArrayList<Integer>) newBallNumber;
    }

    public int getBallNumberByDigit(int digit) {
        return ballNumberList.get(digit);
    }

    public boolean hasThis(int comparisonNumber) {
        return ballNumberList.contains(comparisonNumber);
    }

    public boolean isEqualBallNumberByDigit(BallNumber compBallNumber, int digit) {
        return getBallNumberByDigit(digit) == compBallNumber.getBallNumberByDigit(digit);
    }
}
