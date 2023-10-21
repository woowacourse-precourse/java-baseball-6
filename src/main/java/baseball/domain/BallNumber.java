package baseball.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class BallNumber {
    public ArrayList<Integer> ballNumber = new ArrayList<>();

    public BallNumber(String newBallNumber) {
        ballNumber = (ArrayList<Integer>) newBallNumber
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(toList());
    }

    public BallNumber(ArrayList<Integer> newBallNumber) {
        ballNumber.addAll(newBallNumber);
    }

    public int getBallNumberByDigit(int digit) {
        return ballNumber.get(digit);
    }

    public boolean hasThis(int comparisonNumber) {
        return ballNumber.contains(comparisonNumber);
    }
}
