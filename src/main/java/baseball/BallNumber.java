package baseball;

import java.util.ArrayList;

public class BallNumber {
    ArrayList<Integer> ballnumber = new ArrayList<>();
    BallNumber(int newBallNumber){
        ballnumber.add(newBallNumber / 100);
        ballnumber.add(newBallNumber / 10 % 10);
        ballnumber.add(newBallNumber % 10);
    }
}
