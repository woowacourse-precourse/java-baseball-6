package baseball.Ball;

import static baseball.RuleBook.HOW_MANY_BALLS;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<baseball.Ball.Ball> balls;

    // 유저용
    public Balls(String inputNumbers) {
        chekcBallsLength(inputNumbers);
        balls = ballCheckAndIn(inputNumbers);
    }

    //컴퓨터 용
    public Balls(List<baseball.Ball.Ball> checkBalls){
        checkBallsCount(checkBalls);
        balls = checkBalls;
    }

    private void checkBallsCount(List<baseball.Ball.Ball> checkBalls){
        if(checkBalls.size() == HOW_MANY_BALLS){
            return;
        }
        throw new IllegalArgumentException();
    }

    private void chekcBallsLength(String inputNumbers) {
        if (inputNumbers.length() != HOW_MANY_BALLS) {
            throw new IllegalArgumentException();
        }
    }

    private List<baseball.Ball.Ball> ballCheckAndIn(String inputNumbers) {
        List<baseball.Ball.Ball> inPocket = new ArrayList<>(HOW_MANY_BALLS);

        for (int i = 0; i < HOW_MANY_BALLS; i++) {
            inPocket.add(new baseball.Ball.Ball(inputNumbers.charAt(i)));
        }
        return inPocket;
    }
}
