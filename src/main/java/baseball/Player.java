package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Player {
    public State state;
    private BallBucket ballBucket;

    public Player() {
        this.state = State.START;
    }

    public void guess() {
        this.state = State.CONTINUE;
        this.ballBucket = this.makeInputBucket();
    }

    public BallBucket getBallBucket() {
        return this.ballBucket;
    }

    public void setPlayerState(State state) {
        this.state = state;
    }

    public BallBucket makeInputBucket() {
        System.out.println("숫자를 입력하세요.");
        String input = Console.readLine();

        ArrayList<Integer> ballNumbers = Validator.validateUserInputBalls(input);
        ArrayList<Ball> balls = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Ball newBall = new Ball(ballNumbers.get(i));
            if (balls.contains(newBall)) {
                throw new IllegalArgumentException("중복되는 숫자를 넣어서는 안됩니다.");
            } else {
                balls.add(newBall);
            }
        }
        return new BallBucket(balls);
    }

}
