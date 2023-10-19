package baseball.domain;

import java.util.ArrayList;

public class BallNumber {
    public ArrayList<Integer> ballnumber = new ArrayList<>();
    public BallNumber(int newBallNumber){
        ballnumber.add(newBallNumber / 100);
        ballnumber.add(newBallNumber / 10 % 10);
        ballnumber.add(newBallNumber % 10);
    }
}
