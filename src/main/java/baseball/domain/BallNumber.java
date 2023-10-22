package baseball.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class BallNumber {
    public ArrayList<Integer> ballNumberList = new ArrayList<>();

    public BallNumber(String newBallNumber) {
        ballNumberList = (ArrayList<Integer>) newBallNumber
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(toList());
    }

    public BallNumber(ArrayList<Integer> newBallNumber) {
        ballNumberList = newBallNumber;
    }

    public int getBallNumberByDigit(int digit) {
        return ballNumberList.get(digit);
    }

    public boolean hasThis(int comparisonNumber) {
        return ballNumberList.contains(comparisonNumber);
    }
}
