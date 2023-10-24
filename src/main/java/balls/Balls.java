package balls;

import java.util.List;
import utils.Utils;

public class Balls {
    private final List<Integer> balls;
    Utils utils = new Utils();

    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    public Balls(String input) {
        utils.userGameStartValidation(input);
        this.balls = utils.stringToIntList(input);
    }

    public int getBallsSize() {
        return balls.size();
    }

    public int getBall(int index) {
        return balls.get(index);
    }

    public List<Integer> getBalls() {
        return balls;
    }

    public boolean equals(int digit, int anotherBall) {
        return getBall(digit) == anotherBall;
    }

    public boolean compareToByBall(Balls anotherBalls, int digit) {
        for (int index = 0; index < getBallsSize(); index++) {
            if (digit == index) {
                continue;
            }
            if (equals(digit, anotherBalls.getBall(index))) {
                return true;
            }
        }
        return false;
    }

    public boolean compareToByStrike(Balls anotherBalls, int digit) {
        if (equals(digit, anotherBalls.getBall(digit))) {
            return true;
        }
        return false;
    }
}
