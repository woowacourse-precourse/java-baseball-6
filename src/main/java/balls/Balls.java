package balls;

import java.util.List;
import utils.Utils;

public class Balls {
    List<Integer> balls;
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

    public int getBalls(int index) {
        return balls.get(index);
    }

    public boolean equals(int digit, int anotherBall) {
        return getBalls(digit) == anotherBall;
    }

    public boolean compareToByBall(Balls anotherBalls, int digit) {
        for (int index = 0; index < getBallsSize(); index++) {
            if (digit == index) {
                continue;
            }
            if (equals(digit, anotherBalls.getBalls(index))) {
                return true;
            }
        }
        return false;
    }

    public boolean compareToByStrike(Balls anotherBalls, int digit) {
        if (equals(digit, anotherBalls.getBalls(digit))) {
            return true;
        }
        return false;
    }
}
