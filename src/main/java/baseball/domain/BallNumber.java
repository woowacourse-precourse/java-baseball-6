package baseball.domain;

import java.util.ArrayList;

public class BallNumber {
    public ArrayList<Integer> ballNumber = new ArrayList<>();
    public BallNumber(int newBallNumber) {
        ballNumber.add(newBallNumber / 100);
        ballNumber.add(newBallNumber / 10 % 10);
        ballNumber.add(newBallNumber % 10);
    }
    public BallNumber(ArrayList<Integer> newBallNumber) {
        ballNumber.addAll(newBallNumber);
    }

    public int getBallNumberByDigit(int digit) {
        return ballNumber.get(digit);
    }
}
