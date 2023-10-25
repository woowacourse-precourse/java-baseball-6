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

    public boolean compareByDigit(int digit, int ball) {
        return getBall(digit) == ball;
    }
}

