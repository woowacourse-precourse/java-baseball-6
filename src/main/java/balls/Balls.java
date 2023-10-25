package balls;

import java.util.List;
import java.util.stream.IntStream;
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

    public int countBall(Balls userBalls) {
        return (int) IntStream.range(0, getBallsSize())
                .filter(i -> isBall(i, userBalls))
                .count();
    }

    public boolean isBall(int digit, Balls userBalls) {
        return IntStream.range(0, getBallsSize())
                .filter(index -> digit != index)
                .anyMatch(index -> compareByDigit(digit, userBalls.getBall(index)));
    }

    public int countStrike(Balls userBalls) {
        return (int) IntStream.range(0, getBallsSize())
                .filter(i -> isStrike(i, userBalls))
                .count();
    }

    public boolean isStrike(int digit, Balls userBalls) {
        return compareByDigit(digit, userBalls.getBall(digit));
    }

}

