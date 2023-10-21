package baseball.domain;

import java.util.ArrayList;

public class BallNumber {
    public ArrayList<Integer> ballNumber = new ArrayList<>();

    public BallNumber(String newBallNumber) {
        ballNumber = newBallNumber
                .chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public BallNumber(ArrayList<Integer> newBallNumber) {
        ballNumber.addAll(newBallNumber);
    }

    public int getBallNumberByDigit(int digit) {
        return ballNumber.get(digit);
    }
}
